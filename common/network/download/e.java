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
    private f nvb;
    private File nvc;
    private Executor nvd;
    private c nve;
    private RandomAccessFile nvg;
    private d[] nvf = null;
    private int nvh = 0;
    private g nvi = new g();
    private long mStartTime = -1;
    private int nvj = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d nvq;

        public a(d dVar) {
            this.nvq = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.nvd.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.nvq.wE(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.nvi.p(iOException2);
                        e.this.nve.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.nvd.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.nvg != null) {
                                e.this.nvg.seek(a.this.nvq.getStart());
                                e.this.nvg.write(bytes);
                                a.this.nvq.fj(true);
                                e.this.dIV();
                                e.this.nvi.el(e.this.dIW(), e.this.dIX());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.nvg.close();
                                        e.this.nvg = null;
                                        e.this.dIR().delete();
                                        e.this.nvi.ap(e.this.dIS());
                                        e.this.nve.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.nvi.p(iOException);
                                        e.this.nve.b(e.this, iOException);
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
        this.nvb = fVar;
        this.nvc = file;
        this.nvd = executorService;
        this.mOkHttpClient = okHttpClient;
        this.nve = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dIR() {
        return new File(this.nvc, this.nvb.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dIS() {
        return new File(this.nvc, this.nvb.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIT() throws IOException {
        File dIS = dIS();
        if (dIS.exists() && dIS.length() == this.nvh) {
            this.nvg = new RandomAccessFile(dIS, "rwd");
        } else {
            this.nvg = new RandomAccessFile(dIS, "rws");
            this.nvg.setLength(this.nvh);
        }
        if (this.nvg != null) {
            this.nvg.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.nvf == null) {
                if (!dIU()) {
                    c(callback);
                    return;
                }
                dIT();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.nvf) {
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
        for (d dVar : this.nvf) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.nvb.getUrl()).addHeader(Headers.RANGE, dVar.dIQ()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.nvf) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.nvf) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dIU() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dIR());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.nvb.getName()) && TextUtils.equals(string, this.nvb.getUrl())) {
                this.nvh = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.nvj = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.nvf = new d[jSONArray.length()];
                for (int i = 0; i < this.nvf.length; i++) {
                    this.nvf[i] = d.dX(jSONArray.getJSONObject(i));
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
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.nvb.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.nvd.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.nvh = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.nvd.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.nvh / 131072;
                                if (i == 0) {
                                    e.this.nvf = new d[i + 1];
                                    e.this.nvf[0] = new d(0, true);
                                } else if (e.this.nvh % i == 0) {
                                    e.this.nvf = new d[i];
                                } else {
                                    e.this.nvf = new d[i + 1];
                                    e.this.nvf[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.nvf[i2] = new d(i2 * 131072);
                                }
                                e.this.nvf[e.this.nvf.length - 1].kV(true);
                            } else {
                                e.this.nvf = new d[1];
                                e.this.nvf[0] = new d(0, true);
                            }
                            try {
                                e.this.dIV();
                                e.this.dIT();
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
    public void dIV() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.nvb.getName());
            jSONObject.put("url", this.nvb.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.nvj);
            jSONObject.put("fileLength", this.nvh);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.nvf.length; i++) {
                jSONArray.put(i, this.nvf[i].dIP());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dIR());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dIW() {
        int i = 0;
        for (d dVar : this.nvf) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dIX() {
        return this.nvf.length;
    }

    public State dIY() {
        d[] dVarArr;
        int i = 0;
        if (this.nvf == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.nvf) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.nvf.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.nvf.length) {
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
            this.nvi = gVar;
        }
        switch (dIY()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.nvi.p(iOException);
                        e.this.nve.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.nvg != null) {
                            e.this.nvi.b(e.this.dIS(), e.this.dIW(), e.this.dIX());
                            e.this.nve.c(e.this);
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
        this.nvi = new g();
    }
}
