package d.b.g0.a.b1.d.e;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f43838e;

    /* renamed from: f  reason: collision with root package name */
    public String f43839f;

    /* renamed from: g  reason: collision with root package name */
    public long f43840g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f43841h;

    public void a(MediaModel mediaModel) {
        if (this.f43841h == null) {
            this.f43841h = new ArrayList<>();
        }
        this.f43841h.add(mediaModel);
    }

    public String b() {
        return this.f43839f;
    }

    public String c() {
        return this.f43838e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f43840g));
    }

    public int d() {
        return this.f43841h.size();
    }

    public long e() {
        return this.f43840g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f43838e.equals(((a) obj).f43838e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f43841h;
    }

    public void g(String str) {
        this.f43839f = str;
    }

    public void h(String str) {
        this.f43838e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f43840g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f43838e + ", imageCount=" + d() + "]";
    }
}
