package d.a.j0.q3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f59099a;

    /* renamed from: b  reason: collision with root package name */
    public String f59100b;

    /* renamed from: c  reason: collision with root package name */
    public String f59101c;

    /* renamed from: d  reason: collision with root package name */
    public String f59102d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59103e;

    /* renamed from: f  reason: collision with root package name */
    public String f59104f;

    /* renamed from: g  reason: collision with root package name */
    public String f59105g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59106h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f59100b = str;
        this.f59101c = str2;
        this.f59099a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f59105g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f59105g));
    }

    public boolean b() {
        return this.f59106h;
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
        this.f59106h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f59100b = editVideoData.originPath;
            this.f59101c = editVideoData.coverPath;
            this.f59102d = editVideoData.musicPath;
            this.f59103e = editVideoData.isMute;
            this.f59104f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f59100b = editVideoData.originPath;
            this.f59101c = editVideoData.coverPath;
            this.f59102d = editVideoData.musicPath;
            this.f59103e = editVideoData.isMute;
            this.f59104f = editVideoData.filterName;
        }
        this.f59099a = baseActivity;
    }
}
