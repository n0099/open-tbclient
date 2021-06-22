package d.a.y.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.media.extractor.DuMediaExtractor;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends ExtractorProvider {

    /* renamed from: a  reason: collision with root package name */
    public DuMediaExtractor f68699a;

    public a() {
        try {
            this.f68699a = new DuMediaExtractor();
            b();
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    public static ExtractorProvider a() {
        if (CyberPlayerManager.isCoreLoaded(CyberPlayerManager.getInstallType())) {
            return new a();
        }
        return null;
    }

    public final void b() {
        setOption(1, CyberExtractor.OPT_KEY_PREPARE_TIME_OUT, 5000L);
        setOption(1, "proxytcp-enable", 0L);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        DuMediaExtractor duMediaExtractor = this.f68699a;
        if (duMediaExtractor != null) {
            try {
                return duMediaExtractor.h();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        DuMediaExtractor duMediaExtractor = this.f68699a;
        if (duMediaExtractor != null) {
            try {
                try {
                    duMediaExtractor.b();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f68699a = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        DuMediaExtractor duMediaExtractor = this.f68699a;
        if (duMediaExtractor != null) {
            try {
                duMediaExtractor.e(context, uri, null);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        DuMediaExtractor duMediaExtractor = this.f68699a;
        if (duMediaExtractor != null) {
            try {
                duMediaExtractor.e(context, uri, map);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        DuMediaExtractor duMediaExtractor = this.f68699a;
        if (duMediaExtractor != null) {
            try {
                duMediaExtractor.f(str);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setOption(int i2, String str, long j) {
        CyberLog.i("CyberExtractorImpl", "setOption: " + str + "," + j);
        DuMediaExtractor duMediaExtractor = this.f68699a;
        if (duMediaExtractor != null) {
            try {
                duMediaExtractor.c(i2, str, j);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
