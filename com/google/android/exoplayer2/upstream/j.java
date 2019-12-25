package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes4.dex */
public final class j implements e {
    private final Context context;
    private e lZr;
    private final e mBG;
    private e mBH;
    private e mBI;
    private e mBJ;
    private e mBK;
    private e mBL;
    private final q<? super e> mBd;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mBd = qVar;
        this.mBG = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.lZr == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.lZr = dwB();
            } else {
                this.lZr = dwA();
            }
        } else if ("asset".equals(scheme)) {
            this.lZr = dwB();
        } else if ("content".equals(scheme)) {
            this.lZr = dwC();
        } else if ("rtmp".equals(scheme)) {
            this.lZr = dwD();
        } else if ("data".equals(scheme)) {
            this.lZr = dwE();
        } else {
            this.lZr = this.mBG;
        }
        return this.lZr.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.lZr.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.lZr == null) {
            return null;
        }
        return this.lZr.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.lZr != null) {
            try {
                this.lZr.close();
            } finally {
                this.lZr = null;
            }
        }
    }

    private e dwA() {
        if (this.mBH == null) {
            this.mBH = new FileDataSource(this.mBd);
        }
        return this.mBH;
    }

    private e dwB() {
        if (this.mBI == null) {
            this.mBI = new AssetDataSource(this.context, this.mBd);
        }
        return this.mBI;
    }

    private e dwC() {
        if (this.mBJ == null) {
            this.mBJ = new ContentDataSource(this.context, this.mBd);
        }
        return this.mBJ;
    }

    private e dwD() {
        if (this.mBK == null) {
            try {
                this.mBK = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
            if (this.mBK == null) {
                this.mBK = this.mBG;
            }
        }
        return this.mBK;
    }

    private e dwE() {
        if (this.mBL == null) {
            this.mBL = new d();
        }
        return this.mBL;
    }
}
