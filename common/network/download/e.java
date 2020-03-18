package common.network.download;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidubce.http.Headers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private OkHttpClient mOkHttpClient;
    private f nwO;
    private File nwP;
    private Executor nwQ;
    private c nwR;
    private RandomAccessFile nwT;
    private d[] nwS = null;
    private int nwU = 0;
    private g nwV = new g();
    private long mStartTime = -1;
    private int nwW = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d nxd;

        public a(d dVar) {
            this.nxd = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.nwQ.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.nxd.wM(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.nwV.p(iOException2);
                        e.this.nwR.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.nwQ.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.nwT != null) {
                                e.this.nwT.seek(a.this.nxd.getStart());
                                e.this.nwT.write(bytes);
                                a.this.nxd.fk(true);
                                e.this.dJv();
                                e.this.nwV.em(e.this.dJw(), e.this.dJx());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.nwT.close();
                                        e.this.nwT = null;
                                        e.this.dJr().delete();
                                        e.this.nwV.ap(e.this.dJs());
                                        e.this.nwR.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.nwV.p(iOException);
                                        e.this.nwR.b(e.this, iOException);
                                    }
                                }
                            }
                        } catch (IOException e) {
                            a.this.onFailure(call, e);
                        }
                    }
                });
            } catch (IOException e) {
                onFailure(call, e);
            }
        }
    }

    public e(f fVar, File file, ExecutorService executorService, OkHttpClient okHttpClient, c cVar) {
        this.nwO = fVar;
        this.nwP = file;
        this.nwQ = executorService;
        this.mOkHttpClient = okHttpClient;
        this.nwR = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dJr() {
        return new File(this.nwP, this.nwO.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dJs() {
        return new File(this.nwP, this.nwO.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJt() throws IOException {
        File dJs = dJs();
        if (dJs.exists() && dJs.length() == this.nwU) {
            this.nwT = new RandomAccessFile(dJs, "rwd");
        } else {
            this.nwT = new RandomAccessFile(dJs, "rws");
            this.nwT.setLength(this.nwU);
        }
        if (this.nwT != null) {
            this.nwT.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.nwS == null) {
                if (!dJu()) {
                    c(callback);
                    return;
                }
                dJt();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.nwS) {
                dVar.wM(false);
            }
            callback.onResponse(null, null);
        } catch (IOException e) {
            callback.onFailure(null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        d[] dVarArr;
        for (d dVar : this.nwS) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.nwO.getUrl()).addHeader(Headers.RANGE, dVar.dJq()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.nwS) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.nwS) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dJu() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dJr());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.nwO.getName()) && TextUtils.equals(string, this.nwO.getUrl())) {
                this.nwU = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.nwW = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.nwS = new d[jSONArray.length()];
                for (int i = 0; i < this.nwS.length; i++) {
                    this.nwS[i] = d.dX(jSONArray.getJSONObject(i));
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private void c(final Callback callback) {
        this.mStartTime = System.currentTimeMillis();
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.nwO.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.nwQ.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.nwU = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.nwQ.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.nwU / 131072;
                                if (i == 0) {
                                    e.this.nwS = new d[i + 1];
                                    e.this.nwS[0] = new d(0, true);
                                } else if (e.this.nwU % i == 0) {
                                    e.this.nwS = new d[i];
                                } else {
                                    e.this.nwS = new d[i + 1];
                                    e.this.nwS[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.nwS[i2] = new d(i2 * 131072);
                                }
                                e.this.nwS[e.this.nwS.length - 1].la(true);
                            } else {
                                e.this.nwS = new d[1];
                                e.this.nwS[0] = new d(0, true);
                            }
                            try {
                                e.this.dJv();
                                e.this.dJt();
                                callback.onResponse(null, null);
                            } catch (IOException e) {
                                callback.onFailure(null, new IOException(e));
                            }
                        }
                    });
                } catch (Exception e) {
                    onFailure(call, new IOException(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJv() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.nwO.getName());
            jSONObject.put("url", this.nwO.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.nwW);
            jSONObject.put("fileLength", this.nwU);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.nwS.length; i++) {
                jSONArray.put(i, this.nwS[i].dJp());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dJr());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dJw() {
        int i = 0;
        for (d dVar : this.nwS) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dJx() {
        return this.nwS.length;
    }

    public State dJy() {
        d[] dVarArr;
        int i = 0;
        if (this.nwS == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.nwS) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.nwS.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.nwS.length) {
            return State.FAILED;
        }
        if (this.mOkHttpClient.dispatcher().queuedCallsCount() > 0) {
            return State.RUNNING;
        }
        return State.PAUSED;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public synchronized void a(g gVar) {
        if (gVar != null) {
            this.nwV = gVar;
        }
        switch (dJy()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.nwV.p(iOException);
                        e.this.nwR.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.nwT != null) {
                            e.this.nwV.b(e.this.dJs(), e.this.dJw(), e.this.dJx());
                            e.this.nwR.c(e.this);
                            e.this.execute();
                            return;
                        }
                        onFailure(call, new IOException("没有创建文件，我也不知道为什么"));
                    }
                });
                break;
            case RUNNING:
                break;
            default:
                throw new IllegalStateException("下载任务在一种特殊状态");
        }
    }

    public void cancel() {
        this.mOkHttpClient.dispatcher().cancelAll();
        this.nwV = new g();
    }
}
