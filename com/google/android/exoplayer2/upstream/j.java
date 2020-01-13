package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public final class j implements e {
    private final Context context;
    private final q<? super e> mEV;
    private e mFA;
    private e mFB;
    private e mFC;
    private e mFD;
    private final e mFy;
    private e mFz;
    private e mdj;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mEV = qVar;
        this.mFy = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.mdj == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.mdj = dxM();
            } else {
                this.mdj = dxL();
            }
        } else if ("asset".equals(scheme)) {
            this.mdj = dxM();
        } else if ("content".equals(scheme)) {
            this.mdj = dxN();
        } else if ("rtmp".equals(scheme)) {
            this.mdj = dxO();
        } else if ("data".equals(scheme)) {
            this.mdj = dxP();
        } else {
            this.mdj = this.mFy;
        }
        return this.mdj.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mdj.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mdj == null) {
            return null;
        }
        return this.mdj.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.mdj != null) {
            try {
                this.mdj.close();
            } finally {
                this.mdj = null;
            }
        }
    }

    private e dxL() {
        if (this.mFz == null) {
            this.mFz = new FileDataSource(this.mEV);
        }
        return this.mFz;
    }

    private e dxM() {
        if (this.mFA == null) {
            this.mFA = new AssetDataSource(this.context, this.mEV);
        }
        return this.mFA;
    }

    private e dxN() {
        if (this.mFB == null) {
            this.mFB = new ContentDataSource(this.context, this.mEV);
        }
        return this.mFB;
    }

    private e dxO() {
        if (this.mFC == null) {
            try {
                this.mFC = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
            if (this.mFC == null) {
                this.mFC = this.mFy;
            }
        }
        return this.mFC;
    }

    private e dxP() {
        if (this.mFD == null) {
            this.mFD = new d();
        }
        return this.mFD;
    }
}
