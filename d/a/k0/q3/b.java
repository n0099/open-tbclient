package d.a.k0.q3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f59844a;

    /* renamed from: b  reason: collision with root package name */
    public String f59845b;

    /* renamed from: c  reason: collision with root package name */
    public String f59846c;

    /* renamed from: d  reason: collision with root package name */
    public String f59847d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59848e;

    /* renamed from: f  reason: collision with root package name */
    public String f59849f;

    /* renamed from: g  reason: collision with root package name */
    public String f59850g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59851h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f59845b = str;
        this.f59846c = str2;
        this.f59844a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f59850g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f59850g));
    }

    public boolean b() {
        return this.f59851h;
    }

    public void c() {
        a();
    }

    public void d(int i2, String str) {
        a();
    }

    public abstract void e();

    public void f(VideoInfo videoInfo) {
        a();
    }

    public void g(int i2, String str) {
        a();
    }

    public abstract void h();

    public void i(boolean z) {
        this.f59851h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f59845b = editVideoData.originPath;
            this.f59846c = editVideoData.coverPath;
            this.f59847d = editVideoData.musicPath;
            this.f59848e = editVideoData.isMute;
            this.f59849f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f59845b = editVideoData.originPath;
            this.f59846c = editVideoData.coverPath;
            this.f59847d = editVideoData.musicPath;
            this.f59848e = editVideoData.isMute;
            this.f59849f = editVideoData.filterName;
        }
        this.f59844a = baseActivity;
    }
}
