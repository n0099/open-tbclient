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
    private final q<? super e> mFJ;
    private final e mGl;
    private e mGm;
    private e mGn;
    private e mGo;
    private e mGp;
    private e mGq;
    private e mdW;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mFJ = qVar;
        this.mGl = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.mdW == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.mdW = dza();
            } else {
                this.mdW = dyZ();
            }
        } else if ("asset".equals(scheme)) {
            this.mdW = dza();
        } else if ("content".equals(scheme)) {
            this.mdW = dzb();
        } else if ("rtmp".equals(scheme)) {
            this.mdW = dzc();
        } else if ("data".equals(scheme)) {
            this.mdW = dzd();
        } else {
            this.mdW = this.mGl;
        }
        return this.mdW.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mdW.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mdW == null) {
            return null;
        }
        return this.mdW.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.mdW != null) {
            try {
                this.mdW.close();
            } finally {
                this.mdW = null;
            }
        }
    }

    private e dyZ() {
        if (this.mGm == null) {
            this.mGm = new FileDataSource(this.mFJ);
        }
        return this.mGm;
    }

    private e dza() {
        if (this.mGn == null) {
            this.mGn = new AssetDataSource(this.context, this.mFJ);
        }
        return this.mGn;
    }

    private e dzb() {
        if (this.mGo == null) {
            this.mGo = new ContentDataSource(this.context, this.mFJ);
        }
        return this.mGo;
    }

    private e dzc() {
        if (this.mGp == null) {
            try {
                this.mGp = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
            if (this.mGp == null) {
                this.mGp = this.mGl;
            }
        }
        return this.mGp;
    }

    private e dzd() {
        if (this.mGq == null) {
            this.mGq = new d();
        }
        return this.mGq;
    }
}
