package d.a.l0.a.i1.d.f;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f46564e;

    /* renamed from: f  reason: collision with root package name */
    public String f46565f;

    /* renamed from: g  reason: collision with root package name */
    public long f46566g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f46567h;

    public void a(MediaModel mediaModel) {
        if (this.f46567h == null) {
            this.f46567h = new ArrayList<>();
        }
        this.f46567h.add(mediaModel);
    }

    public String b() {
        return this.f46565f;
    }

    public String c() {
        return this.f46564e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f46566g));
    }

    public int d() {
        return this.f46567h.size();
    }

    public long e() {
        return this.f46566g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f46564e.equals(((a) obj).f46564e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f46567h;
    }

    public void g(String str) {
        this.f46565f = str;
    }

    public void h(String str) {
        this.f46564e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f46566g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f46564e + ", imageCount=" + d() + "]";
    }
}
