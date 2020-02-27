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
    private f nuO;
    private File nuP;
    private Executor nuQ;
    private c nuR;
    private RandomAccessFile nuT;
    private d[] nuS = null;
    private int nuU = 0;
    private g nuV = new g();
    private long mStartTime = -1;
    private int nuW = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d nvd;

        public a(d dVar) {
            this.nvd = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.nuQ.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.nvd.wE(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.nuV.p(iOException2);
                        e.this.nuR.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.nuQ.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.nuT != null) {
                                e.this.nuT.seek(a.this.nvd.getStart());
                                e.this.nuT.write(bytes);
                                a.this.nvd.fj(true);
                                e.this.dIS();
                                e.this.nuV.el(e.this.dIT(), e.this.dIU());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.nuT.close();
                                        e.this.nuT = null;
                                        e.this.dIO().delete();
                                        e.this.nuV.ap(e.this.dIP());
                                        e.this.nuR.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.nuV.p(iOException);
                                        e.this.nuR.b(e.this, iOException);
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
        this.nuO = fVar;
        this.nuP = file;
        this.nuQ = executorService;
        this.mOkHttpClient = okHttpClient;
        this.nuR = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dIO() {
        return new File(this.nuP, this.nuO.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dIP() {
        return new File(this.nuP, this.nuO.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIQ() throws IOException {
        File dIP = dIP();
        if (dIP.exists() && dIP.length() == this.nuU) {
            this.nuT = new RandomAccessFile(dIP, "rwd");
        } else {
            this.nuT = new RandomAccessFile(dIP, "rws");
            this.nuT.setLength(this.nuU);
        }
        if (this.nuT != null) {
            this.nuT.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.nuS == null) {
                if (!dIR()) {
                    c(callback);
                    return;
                }
                dIQ();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.nuS) {
                dVar.wE(false);
            }
            callback.onResponse(null, null);
        } catch (IOException e) {
            callback.onFailure(null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        d[] dVarArr;
        for (d dVar : this.nuS) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.nuO.getUrl()).addHeader(Headers.RANGE, dVar.dIN()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.nuS) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.nuS) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dIR() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dIO());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.nuO.getName()) && TextUtils.equals(string, this.nuO.getUrl())) {
                this.nuU = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.nuW = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.nuS = new d[jSONArray.length()];
                for (int i = 0; i < this.nuS.length; i++) {
                    this.nuS[i] = d.dX(jSONArray.getJSONObject(i));
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
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.nuO.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.nuQ.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.nuU = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.nuQ.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.nuU / 131072;
                                if (i == 0) {
                                    e.this.nuS = new d[i + 1];
                                    e.this.nuS[0] = new d(0, true);
                                } else if (e.this.nuU % i == 0) {
                                    e.this.nuS = new d[i];
                                } else {
                                    e.this.nuS = new d[i + 1];
                                    e.this.nuS[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.nuS[i2] = new d(i2 * 131072);
                                }
                                e.this.nuS[e.this.nuS.length - 1].kV(true);
                            } else {
                                e.this.nuS = new d[1];
                                e.this.nuS[0] = new d(0, true);
                            }
                            try {
                                e.this.dIS();
                                e.this.dIQ();
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
    public void dIS() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.nuO.getName());
            jSONObject.put("url", this.nuO.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.nuW);
            jSONObject.put("fileLength", this.nuU);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.nuS.length; i++) {
                jSONArray.put(i, this.nuS[i].dIM());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dIO());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dIT() {
        int i = 0;
        for (d dVar : this.nuS) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dIU() {
        return this.nuS.length;
    }

    public State dIV() {
        d[] dVarArr;
        int i = 0;
        if (this.nuS == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.nuS) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.nuS.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.nuS.length) {
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
            this.nuV = gVar;
        }
        switch (dIV()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.nuV.p(iOException);
                        e.this.nuR.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.nuT != null) {
                            e.this.nuV.b(e.this.dIP(), e.this.dIT(), e.this.dIU());
                            e.this.nuR.c(e.this);
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
        this.nuV = new g();
    }
}
