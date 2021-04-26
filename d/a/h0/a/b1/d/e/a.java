package d.a.h0.a.b1.d.e;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f41443e;

    /* renamed from: f  reason: collision with root package name */
    public String f41444f;

    /* renamed from: g  reason: collision with root package name */
    public long f41445g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f41446h;

    public void a(MediaModel mediaModel) {
        if (this.f41446h == null) {
            this.f41446h = new ArrayList<>();
        }
        this.f41446h.add(mediaModel);
    }

    public String b() {
        return this.f41444f;
    }

    public String c() {
        return this.f41443e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f41445g));
    }

    public int d() {
        return this.f41446h.size();
    }

    public long e() {
        return this.f41445g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f41443e.equals(((a) obj).f41443e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f41446h;
    }

    public void g(String str) {
        this.f41444f = str;
    }

    public void h(String str) {
        this.f41443e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f41445g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f41443e + ", imageCount=" + d() + "]";
    }
}
