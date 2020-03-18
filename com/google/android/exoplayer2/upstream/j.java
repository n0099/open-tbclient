package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes6.dex */
public final class j implements e {
    private final Context context;
    private final q<? super e> mHA;
    private final e mIc;
    private e mIe;
    private e mIf;
    private e mIg;
    private e mIh;
    private e mIi;
    private e mfN;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mHA = qVar;
        this.mIc = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.mfN == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.mfN = dzy();
            } else {
                this.mfN = dzx();
            }
        } else if ("asset".equals(scheme)) {
            this.mfN = dzy();
        } else if ("content".equals(scheme)) {
            this.mfN = dzz();
        } else if ("rtmp".equals(scheme)) {
            this.mfN = dzA();
        } else if ("data".equals(scheme)) {
            this.mfN = dzB();
        } else {
            this.mfN = this.mIc;
        }
        return this.mfN.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mfN.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mfN == null) {
            return null;
        }
        return this.mfN.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.mfN != null) {
            try {
                this.mfN.close();
            } finally {
                this.mfN = null;
            }
        }
    }

    private e dzx() {
        if (this.mIe == null) {
            this.mIe = new FileDataSource(this.mHA);
        }
        return this.mIe;
    }

    private e dzy() {
        if (this.mIf == null) {
            this.mIf = new AssetDataSource(this.context, this.mHA);
        }
        return this.mIf;
    }

    private e dzz() {
        if (this.mIg == null) {
            this.mIg = new ContentDataSource(this.context, this.mHA);
        }
        return this.mIg;
    }

    private e dzA() {
        if (this.mIh == null) {
            try {
                this.mIh = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (IllegalAccessException e2) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e2);
            } catch (InstantiationException e3) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e4);
            } catch (InvocationTargetException e5) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e5);
            }
            if (this.mIh == null) {
                this.mIh = this.mIc;
            }
        }
        return this.mIh;
    }

    private e dzB() {
        if (this.mIi == null) {
            this.mIi = new d();
        }
        return this.mIi;
    }
}
