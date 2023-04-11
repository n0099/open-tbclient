package com.yy.hiidostatis.defs.controller;

import com.yy.hiidostatis.defs.obj.SendCell;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.http.IStatisHttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class HttpSendController {
    public File cacheDir;
    public int delayStep;
    public IStatisHttpUtil httpUtil;
    public TreeMap<Long, SendCell> waitForSend = new TreeMap<>();
    public int waitQueueCapacity;

    public HttpSendController(IStatisHttpUtil iStatisHttpUtil, File file, int i, int i2) {
        this.waitQueueCapacity = 20;
        this.delayStep = 2;
        this.httpUtil = iStatisHttpUtil;
        this.cacheDir = file;
        this.waitQueueCapacity = i;
        this.delayStep = i2;
        loadSendCellFromFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(final SendCell sendCell) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.HttpSendController.1
            @Override // java.lang.Runnable
            public void run() {
                sendCell.saveToFile(HttpSendController.this.cacheDir);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendHttp(long j) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.HttpSendController.3
            @Override // java.lang.Runnable
            public void run() {
                SendCell pollTask = HttpSendController.this.pollTask();
                if (pollTask == null) {
                    HttpSendController.this.loadSendCellFromFile();
                    return;
                }
                try {
                    String format = String.format("%s&hd_stime=%d", pollTask.getContent(), Long.valueOf(Util.wallTimeMillis()));
                    HttpSendController.this.httpUtil.setLastTryTimes(pollTask.getRetry());
                    boolean sendSync = HttpSendController.this.httpUtil.sendSync(format);
                    int lastTryTimes = HttpSendController.this.httpUtil.getLastTryTimes();
                    L.debug(this, "Return value: %B to send command %s. ", Boolean.valueOf(sendSync), format);
                    if (!sendSync) {
                        if (HttpSendController.this.httpUtil.getLastStatusCode() != 414 && HttpSendController.this.httpUtil.getLastStatusCode() != 400) {
                            L.warn(this, "data:%s ; all tryTimes:%d ; createTime:%d", Long.valueOf(pollTask.getId()), Integer.valueOf(lastTryTimes), Long.valueOf(pollTask.getTimestamp()));
                            pollTask.retryIncrease();
                            HttpSendController.this.save(pollTask);
                            HttpSendController.this.putTask(pollTask);
                            HttpSendController.this.sendHttp((pollTask.getRetry() + 1) * HttpSendController.this.delayStep);
                        }
                        pollTask.deleteFile(HttpSendController.this.cacheDir);
                        L.warn(this, "httpUtil.getLastStatusCode()=%d,removeInvalid:%s", Integer.valueOf(HttpSendController.this.httpUtil.getLastStatusCode()), pollTask.getContent());
                        HttpSendController.this.sendHttp(0L);
                    } else {
                        pollTask.deleteFile(HttpSendController.this.cacheDir);
                        HttpSendController.this.sendHttp(0L);
                    }
                } catch (Throwable th) {
                    L.debug(this, th.getMessage(), new Object[0]);
                }
            }
        }, j * 1000);
    }

    public void send(String str, long j) {
        putTask(new SendCell(str, j));
        sendHttp(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSendCellFromFile() {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.HttpSendController.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File[] listFiles = HttpSendController.this.cacheDir.listFiles();
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = HttpSendController.this.waitForSend.size();
                    for (File file : listFiles) {
                        if (size >= HttpSendController.this.waitQueueCapacity) {
                            return;
                        }
                        long parseId = SendCell.parseId(file.getName());
                        if (parseId > 0) {
                            if (parseId / 10000 <= currentTimeMillis) {
                                file.delete();
                            } else {
                                HttpSendController.this.putTask(SendCell.loadFromFile(file));
                                size++;
                            }
                        }
                    }
                    if (size <= 0) {
                        return;
                    }
                    HttpSendController.this.sendHttp(0L);
                } catch (Throwable th) {
                    L.debug(this, th.getMessage(), new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SendCell pollTask() {
        synchronized (this.waitForSend) {
            Map.Entry<Long, SendCell> pollLastEntry = this.waitForSend.pollLastEntry();
            if (pollLastEntry != null) {
                return pollLastEntry.getValue();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putTask(SendCell sendCell) {
        Map.Entry<Long, SendCell> pollFirstEntry;
        synchronized (this.waitForSend) {
            this.waitForSend.put(Long.valueOf(sendCell.getId()), sendCell);
            if (this.waitForSend.size() > this.waitQueueCapacity && (pollFirstEntry = this.waitForSend.pollFirstEntry()) != null && pollFirstEntry.getValue() != null) {
                save(pollFirstEntry.getValue());
            }
        }
    }
}
