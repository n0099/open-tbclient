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
    private f nuQ;
    private File nuR;
    private Executor nuS;
    private c nuT;
    private RandomAccessFile nuV;
    private d[] nuU = null;
    private int nuW = 0;
    private g nuX = new g();
    private long mStartTime = -1;
    private int nuY = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d nvf;

        public a(d dVar) {
            this.nvf = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.nuS.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.nvf.wE(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.nuX.p(iOException2);
                        e.this.nuT.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.nuS.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.nuV != null) {
                                e.this.nuV.seek(a.this.nvf.getStart());
                                e.this.nuV.write(bytes);
                                a.this.nvf.fj(true);
                                e.this.dIU();
                                e.this.nuX.el(e.this.dIV(), e.this.dIW());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.nuV.close();
                                        e.this.nuV = null;
                                        e.this.dIQ().delete();
                                        e.this.nuX.ap(e.this.dIR());
                                        e.this.nuT.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.nuX.p(iOException);
                                        e.this.nuT.b(e.this, iOException);
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
        this.nuQ = fVar;
        this.nuR = file;
        this.nuS = executorService;
        this.mOkHttpClient = okHttpClient;
        this.nuT = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dIQ() {
        return new File(this.nuR, this.nuQ.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dIR() {
        return new File(this.nuR, this.nuQ.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIS() throws IOException {
        File dIR = dIR();
        if (dIR.exists() && dIR.length() == this.nuW) {
            this.nuV = new RandomAccessFile(dIR, "rwd");
        } else {
            this.nuV = new RandomAccessFile(dIR, "rws");
            this.nuV.setLength(this.nuW);
        }
        if (this.nuV != null) {
            this.nuV.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.nuU == null) {
                if (!dIT()) {
                    c(callback);
                    return;
                }
                dIS();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.nuU) {
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
        for (d dVar : this.nuU) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.nuQ.getUrl()).addHeader(Headers.RANGE, dVar.dIP()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.nuU) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.nuU) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dIT() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dIQ());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.nuQ.getName()) && TextUtils.equals(string, this.nuQ.getUrl())) {
                this.nuW = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.nuY = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.nuU = new d[jSONArray.length()];
                for (int i = 0; i < this.nuU.length; i++) {
                    this.nuU[i] = d.dX(jSONArray.getJSONObject(i));
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
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.nuQ.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.nuS.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.nuW = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.nuS.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.nuW / 131072;
                                if (i == 0) {
                                    e.this.nuU = new d[i + 1];
                                    e.this.nuU[0] = new d(0, true);
                                } else if (e.this.nuW % i == 0) {
                                    e.this.nuU = new d[i];
                                } else {
                                    e.this.nuU = new d[i + 1];
                                    e.this.nuU[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.nuU[i2] = new d(i2 * 131072);
                                }
                                e.this.nuU[e.this.nuU.length - 1].kV(true);
                            } else {
                                e.this.nuU = new d[1];
                                e.this.nuU[0] = new d(0, true);
                            }
                            try {
                                e.this.dIU();
                                e.this.dIS();
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
    public void dIU() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.nuQ.getName());
            jSONObject.put("url", this.nuQ.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.nuY);
            jSONObject.put("fileLength", this.nuW);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.nuU.length; i++) {
                jSONArray.put(i, this.nuU[i].dIO());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dIQ());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dIV() {
        int i = 0;
        for (d dVar : this.nuU) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dIW() {
        return this.nuU.length;
    }

    public State dIX() {
        d[] dVarArr;
        int i = 0;
        if (this.nuU == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.nuU) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.nuU.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.nuU.length) {
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
            this.nuX = gVar;
        }
        switch (dIX()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.nuX.p(iOException);
                        e.this.nuT.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.nuV != null) {
                            e.this.nuX.b(e.this.dIR(), e.this.dIV(), e.this.dIW());
                            e.this.nuT.c(e.this);
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
        this.nuX = new g();
    }
}
