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
    private f nug;
    private File nuh;
    private Executor nui;
    private c nuj;
    private RandomAccessFile nul;
    private d[] nuk = null;
    private int nun = 0;
    private g nuo = new g();
    private long mStartTime = -1;
    private int nup = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d nuw;

        public a(d dVar) {
            this.nuw = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.nui.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.nuw.wB(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.nuo.p(iOException2);
                        e.this.nuj.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.nui.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.nul != null) {
                                e.this.nul.seek(a.this.nuw.getStart());
                                e.this.nul.write(bytes);
                                a.this.nuw.fc(true);
                                e.this.dHJ();
                                e.this.nuo.ei(e.this.dHK(), e.this.dHL());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.nul.close();
                                        e.this.nul = null;
                                        e.this.dHF().delete();
                                        e.this.nuo.an(e.this.dHG());
                                        e.this.nuj.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.nuo.p(iOException);
                                        e.this.nuj.b(e.this, iOException);
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
        this.nug = fVar;
        this.nuh = file;
        this.nui = executorService;
        this.mOkHttpClient = okHttpClient;
        this.nuj = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dHF() {
        return new File(this.nuh, this.nug.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dHG() {
        return new File(this.nuh, this.nug.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHH() throws IOException {
        File dHG = dHG();
        if (dHG.exists() && dHG.length() == this.nun) {
            this.nul = new RandomAccessFile(dHG, "rwd");
        } else {
            this.nul = new RandomAccessFile(dHG, "rws");
            this.nul.setLength(this.nun);
        }
        if (this.nul != null) {
            this.nul.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.nuk == null) {
                if (!dHI()) {
                    c(callback);
                    return;
                }
                dHH();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.nuk) {
                dVar.wB(false);
            }
            callback.onResponse(null, null);
        } catch (IOException e) {
            callback.onFailure(null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        d[] dVarArr;
        for (d dVar : this.nuk) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.nug.getUrl()).addHeader(Headers.RANGE, dVar.dHE()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.nuk) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.nuk) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dHI() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dHF());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.nug.getName()) && TextUtils.equals(string, this.nug.getUrl())) {
                this.nun = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.nup = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.nuk = new d[jSONArray.length()];
                for (int i = 0; i < this.nuk.length; i++) {
                    this.nuk[i] = d.dX(jSONArray.getJSONObject(i));
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
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.nug.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.nui.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.nun = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.nui.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.nun / 131072;
                                if (i == 0) {
                                    e.this.nuk = new d[i + 1];
                                    e.this.nuk[0] = new d(0, true);
                                } else if (e.this.nun % i == 0) {
                                    e.this.nuk = new d[i];
                                } else {
                                    e.this.nuk = new d[i + 1];
                                    e.this.nuk[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.nuk[i2] = new d(i2 * 131072);
                                }
                                e.this.nuk[e.this.nuk.length - 1].kR(true);
                            } else {
                                e.this.nuk = new d[1];
                                e.this.nuk[0] = new d(0, true);
                            }
                            try {
                                e.this.dHJ();
                                e.this.dHH();
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
    public void dHJ() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.nug.getName());
            jSONObject.put("url", this.nug.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.nup);
            jSONObject.put("fileLength", this.nun);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.nuk.length; i++) {
                jSONArray.put(i, this.nuk[i].dHD());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dHF());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dHK() {
        int i = 0;
        for (d dVar : this.nuk) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dHL() {
        return this.nuk.length;
    }

    public State dHM() {
        d[] dVarArr;
        int i = 0;
        if (this.nuk == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.nuk) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.nuk.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.nuk.length) {
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
            this.nuo = gVar;
        }
        switch (dHM()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.nuo.p(iOException);
                        e.this.nuj.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.nul != null) {
                            e.this.nuo.b(e.this.dHG(), e.this.dHK(), e.this.dHL());
                            e.this.nuj.c(e.this);
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
        this.nuo = new g();
    }
}
