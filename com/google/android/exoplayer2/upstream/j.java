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
    private final e mFD;
    private e mFE;
    private e mFF;
    private e mFG;
    private e mFH;
    private e mFI;
    private final q<? super e> mFa;
    private e mdo;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mFa = qVar;
        this.mFD = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.mdo == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.mdo = dxO();
            } else {
                this.mdo = dxN();
            }
        } else if ("asset".equals(scheme)) {
            this.mdo = dxO();
        } else if ("content".equals(scheme)) {
            this.mdo = dxP();
        } else if ("rtmp".equals(scheme)) {
            this.mdo = dxQ();
        } else if ("data".equals(scheme)) {
            this.mdo = dxR();
        } else {
            this.mdo = this.mFD;
        }
        return this.mdo.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mdo.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mdo == null) {
            return null;
        }
        return this.mdo.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.mdo != null) {
            try {
                this.mdo.close();
            } finally {
                this.mdo = null;
            }
        }
    }

    private e dxN() {
        if (this.mFE == null) {
            this.mFE = new FileDataSource(this.mFa);
        }
        return this.mFE;
    }

    private e dxO() {
        if (this.mFF == null) {
            this.mFF = new AssetDataSource(this.context, this.mFa);
        }
        return this.mFF;
    }

    private e dxP() {
        if (this.mFG == null) {
            this.mFG = new ContentDataSource(this.context, this.mFa);
        }
        return this.mFG;
    }

    private e dxQ() {
        if (this.mFH == null) {
            try {
                this.mFH = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
            if (this.mFH == null) {
                this.mFH = this.mFD;
            }
        }
        return this.mFH;
    }

    private e dxR() {
        if (this.mFI == null) {
            this.mFI = new d();
        }
        return this.mFI;
    }
}
