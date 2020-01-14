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
    private f nul;
    private File nun;
    private Executor nuo;
    private c nup;
    private RandomAccessFile nur;
    private d[] nuq = null;
    private int nus = 0;
    private g nut = new g();
    private long mStartTime = -1;
    private int nuu = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d nuB;

        public a(d dVar) {
            this.nuB = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.nuo.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.nuB.wB(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.nut.p(iOException2);
                        e.this.nup.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.nuo.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.nur != null) {
                                e.this.nur.seek(a.this.nuB.getStart());
                                e.this.nur.write(bytes);
                                a.this.nuB.fc(true);
                                e.this.dHL();
                                e.this.nut.ei(e.this.dHM(), e.this.dHN());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.nur.close();
                                        e.this.nur = null;
                                        e.this.dHH().delete();
                                        e.this.nut.an(e.this.dHI());
                                        e.this.nup.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.nut.p(iOException);
                                        e.this.nup.b(e.this, iOException);
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
        this.nul = fVar;
        this.nun = file;
        this.nuo = executorService;
        this.mOkHttpClient = okHttpClient;
        this.nup = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dHH() {
        return new File(this.nun, this.nul.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dHI() {
        return new File(this.nun, this.nul.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHJ() throws IOException {
        File dHI = dHI();
        if (dHI.exists() && dHI.length() == this.nus) {
            this.nur = new RandomAccessFile(dHI, "rwd");
        } else {
            this.nur = new RandomAccessFile(dHI, "rws");
            this.nur.setLength(this.nus);
        }
        if (this.nur != null) {
            this.nur.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.nuq == null) {
                if (!dHK()) {
                    c(callback);
                    return;
                }
                dHJ();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.nuq) {
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
        for (d dVar : this.nuq) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.nul.getUrl()).addHeader(Headers.RANGE, dVar.dHG()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.nuq) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.nuq) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dHK() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dHH());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.nul.getName()) && TextUtils.equals(string, this.nul.getUrl())) {
                this.nus = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.nuu = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.nuq = new d[jSONArray.length()];
                for (int i = 0; i < this.nuq.length; i++) {
                    this.nuq[i] = d.dX(jSONArray.getJSONObject(i));
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
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.nul.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.nuo.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.nus = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.nuo.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.nus / 131072;
                                if (i == 0) {
                                    e.this.nuq = new d[i + 1];
                                    e.this.nuq[0] = new d(0, true);
                                } else if (e.this.nus % i == 0) {
                                    e.this.nuq = new d[i];
                                } else {
                                    e.this.nuq = new d[i + 1];
                                    e.this.nuq[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.nuq[i2] = new d(i2 * 131072);
                                }
                                e.this.nuq[e.this.nuq.length - 1].kR(true);
                            } else {
                                e.this.nuq = new d[1];
                                e.this.nuq[0] = new d(0, true);
                            }
                            try {
                                e.this.dHL();
                                e.this.dHJ();
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
    public void dHL() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.nul.getName());
            jSONObject.put("url", this.nul.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.nuu);
            jSONObject.put("fileLength", this.nus);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.nuq.length; i++) {
                jSONArray.put(i, this.nuq[i].dHF());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dHH());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dHM() {
        int i = 0;
        for (d dVar : this.nuq) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dHN() {
        return this.nuq.length;
    }

    public State dHO() {
        d[] dVarArr;
        int i = 0;
        if (this.nuq == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.nuq) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.nuq.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.nuq.length) {
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
            this.nut = gVar;
        }
        switch (dHO()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.nut.p(iOException);
                        e.this.nup.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.nur != null) {
                            e.this.nut.b(e.this.dHI(), e.this.dHM(), e.this.dHN());
                            e.this.nup.c(e.this);
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
        this.nut = new g();
    }
}
