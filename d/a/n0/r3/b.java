package d.a.n0.r3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f59985a;

    /* renamed from: b  reason: collision with root package name */
    public String f59986b;

    /* renamed from: c  reason: collision with root package name */
    public String f59987c;

    /* renamed from: d  reason: collision with root package name */
    public String f59988d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59989e;

    /* renamed from: f  reason: collision with root package name */
    public String f59990f;

    /* renamed from: g  reason: collision with root package name */
    public String f59991g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59992h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f59986b = str;
        this.f59987c = str2;
        this.f59985a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f59991g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f59991g));
    }

    public boolean b() {
        return this.f59992h;
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
        this.f59992h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f59986b = editVideoData.originPath;
            this.f59987c = editVideoData.coverPath;
            this.f59988d = editVideoData.musicPath;
            this.f59989e = editVideoData.isMute;
            this.f59990f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f59986b = editVideoData.originPath;
            this.f59987c = editVideoData.coverPath;
            this.f59988d = editVideoData.musicPath;
            this.f59989e = editVideoData.isMute;
            this.f59990f = editVideoData.filterName;
        }
        this.f59985a = baseActivity;
    }
}
