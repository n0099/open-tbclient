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
    private f mRZ;
    private File mSa;
    private Executor mSb;
    private c mSc;
    private RandomAccessFile mSe;
    private d[] mSd = null;
    private int mSf = 0;
    private g mSg = new g();
    private long mStartTime = -1;
    private int mSh = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callback {
        private d mSq;

        public a(d dVar) {
            this.mSq = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(final Call call, IOException iOException) {
            e.this.mSb.execute(new Runnable() { // from class: common.network.download.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!call.isCanceled()) {
                        a.this.mSq.wc(true);
                    }
                    if (e.this.isExecuted()) {
                        IOException iOException2 = new IOException("piece(s) failed");
                        e.this.mSg.p(iOException2);
                        e.this.mSc.b(e.this, iOException2);
                    }
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(final Call call, Response response) throws IOException {
            try {
                final byte[] bytes = response.body().bytes();
                e.this.mSb.execute(new Runnable() { // from class: common.network.download.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (e.this.mSe != null) {
                                e.this.mSe.seek(a.this.mSq.getStart());
                                e.this.mSe.write(bytes);
                                a.this.mSq.eX(true);
                                e.this.dDD();
                                e.this.mSg.eh(e.this.dDE(), e.this.dDF());
                                if (e.this.isExecuted()) {
                                    if (e.this.aW()) {
                                        e.this.mSe.close();
                                        e.this.mSe = null;
                                        e.this.dDz().delete();
                                        e.this.mSg.al(e.this.dDA());
                                        e.this.mSc.d(e.this);
                                    } else {
                                        IOException iOException = new IOException("piece(s) failed");
                                        e.this.mSg.p(iOException);
                                        e.this.mSc.b(e.this, iOException);
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
        this.mRZ = fVar;
        this.mSa = file;
        this.mSb = executorService;
        this.mOkHttpClient = okHttpClient;
        this.mSc = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dDz() {
        return new File(this.mSa, this.mRZ.getName().concat(".json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File dDA() {
        return new File(this.mSa, this.mRZ.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDB() throws IOException {
        File dDA = dDA();
        if (dDA.exists() && dDA.length() == this.mSf) {
            this.mSe = new RandomAccessFile(dDA, "rwd");
        } else {
            this.mSe = new RandomAccessFile(dDA, "rws");
            this.mSe.setLength(this.mSf);
        }
        if (this.mSe != null) {
            this.mSe.close();
        }
    }

    private void b(Callback callback) {
        try {
            if (this.mSd == null) {
                if (!dDC()) {
                    c(callback);
                    return;
                }
                dDB();
                callback.onResponse(null, null);
                return;
            }
            for (d dVar : this.mSd) {
                dVar.wc(false);
            }
            callback.onResponse(null, null);
        } catch (IOException e) {
            callback.onFailure(null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        d[] dVarArr;
        for (d dVar : this.mSd) {
            if (!dVar.aW()) {
                this.mOkHttpClient.newCall(new Request.Builder().get().url(this.mRZ.getUrl()).addHeader(Headers.RANGE, dVar.dDy()).build()).enqueue(new a(dVar));
            }
        }
    }

    public boolean aW() {
        for (d dVar : this.mSd) {
            if (!dVar.aW()) {
                return false;
            }
        }
        return true;
    }

    public boolean isExecuted() {
        d[] dVarArr;
        for (d dVar : this.mSd) {
            if (!dVar.aW() && !dVar.isFailed()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private boolean dDC() {
        try {
            FileInputStream fileInputStream = new FileInputStream(dDz());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String string = jSONObject.getString("url");
            if (TextUtils.equals(jSONObject.getString("name"), this.mRZ.getName()) && TextUtils.equals(string, this.mRZ.getUrl())) {
                this.mSf = jSONObject.getInt("fileLength");
                this.mStartTime = jSONObject.getLong("startTime");
                this.mSh = jSONObject.getInt("procCount") + 1;
                JSONArray jSONArray = jSONObject.getJSONArray("pieces");
                this.mSd = new d[jSONArray.length()];
                for (int i = 0; i < this.mSd.length; i++) {
                    this.mSd[i] = d.dG(jSONArray.getJSONObject(i));
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
        this.mOkHttpClient.newCall(new Request.Builder().head().url(this.mRZ.getUrl()).build()).enqueue(new Callback() { // from class: common.network.download.e.1
            @Override // okhttp3.Callback
            public void onFailure(final Call call, final IOException iOException) {
                e.this.mSb.execute(new Runnable() { // from class: common.network.download.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onFailure(call, iOException);
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    e.this.mSf = Integer.parseInt(response.header("Content-Length"));
                    final boolean equals = TextUtils.equals(response.header("Accept-Ranges"), "bytes");
                    e.this.mSb.execute(new Runnable() { // from class: common.network.download.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (equals) {
                                int i = e.this.mSf / 131072;
                                if (i == 0) {
                                    e.this.mSd = new d[i + 1];
                                    e.this.mSd[0] = new d(0, true);
                                } else if (e.this.mSf % i == 0) {
                                    e.this.mSd = new d[i];
                                } else {
                                    e.this.mSd = new d[i + 1];
                                    e.this.mSd[i] = new d(i * 131072, true);
                                }
                                for (int i2 = 0; i2 < i; i2++) {
                                    e.this.mSd[i2] = new d(i2 * 131072);
                                }
                                e.this.mSd[e.this.mSd.length - 1].kG(true);
                            } else {
                                e.this.mSd = new d[1];
                                e.this.mSd[0] = new d(0, true);
                            }
                            try {
                                e.this.dDD();
                                e.this.dDB();
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
    public void dDD() throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.mRZ.getName());
            jSONObject.put("url", this.mRZ.getUrl());
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("procCount", this.mSh);
            jSONObject.put("fileLength", this.mSf);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.mSd.length; i++) {
                jSONArray.put(i, this.mSd[i].dDx());
            }
            jSONObject.put("pieces", jSONArray);
            FileOutputStream fileOutputStream = new FileOutputStream(dDz());
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public int dDE() {
        int i = 0;
        for (d dVar : this.mSd) {
            if (dVar.aW()) {
                i++;
            }
        }
        return i;
    }

    public int dDF() {
        return this.mSd.length;
    }

    public State dDG() {
        d[] dVarArr;
        int i = 0;
        if (this.mSd == null) {
            return State.PAUSED;
        }
        int i2 = 0;
        for (d dVar : this.mSd) {
            if (dVar.aW()) {
                i++;
            } else if (dVar.isFailed()) {
                i2++;
            }
        }
        if (i == this.mSd.length) {
            return State.COMPLETED;
        }
        if (i + i2 == this.mSd.length) {
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
            this.mSg = gVar;
        }
        switch (dDG()) {
            case PAUSED:
            case COMPLETED:
            case FAILED:
                b(new Callback() { // from class: common.network.download.e.2
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        e.this.mSg.p(iOException);
                        e.this.mSc.b(e.this, iOException);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        if (e.this.mSe != null) {
                            e.this.mSg.b(e.this.dDA(), e.this.dDE(), e.this.dDF());
                            e.this.mSc.c(e.this);
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
        this.mSg = new g();
    }
}
