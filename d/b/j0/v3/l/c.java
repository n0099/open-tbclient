package d.b.j0.v3.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public final d.b.c.a.f f63751b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f63752c;

    /* renamed from: d  reason: collision with root package name */
    public VideoFileInfo f63753d;

    /* renamed from: e  reason: collision with root package name */
    public String f63754e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo f63755f;

    /* renamed from: g  reason: collision with root package name */
    public List<ImageFileInfo> f63756g;

    /* renamed from: a  reason: collision with root package name */
    public int f63750a = 9;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.i0.e.a> f63757h = new ArrayList();

    public c(d.b.c.a.f fVar) {
        this.f63751b = fVar;
    }

    public void A(String str) {
        if (this.f63752c == null) {
            this.f63752c = new WriteImagesInfo(this.f63750a);
        }
        this.f63752c.setLastAlbumId(str);
    }

    public void B(boolean z) {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo != null) {
            writeImagesInfo.setOriginalImg(z);
        }
    }

    public void C(WriteImagesInfo writeImagesInfo) {
        this.f63752c = writeImagesInfo;
    }

    public int D() {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo == null) {
            return 0;
        }
        return writeImagesInfo.size();
    }

    public void a(ImageFileInfo imageFileInfo) {
        if (this.f63752c == null) {
            this.f63752c = new WriteImagesInfo(this.f63750a);
        }
        this.f63752c.addChooseFile(imageFileInfo);
    }

    public void b() {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo == null) {
            return;
        }
        writeImagesInfo.clear();
    }

    public void c(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo == null) {
            return;
        }
        writeImagesInfo.delChooseFile(imageFileInfo);
    }

    public List<MediaFileInfo> d(String str) {
        if (this.f63757h != null && !StringUtils.isNull(str)) {
            for (d.b.i0.e.a aVar : this.f63757h) {
                if (aVar != null && TextUtils.equals(str, aVar.b())) {
                    return aVar.d();
                }
            }
        }
        return null;
    }

    public List<d.b.i0.e.a> e() {
        return this.f63757h;
    }

    public VideoFileInfo f() {
        return this.f63753d;
    }

    public List<ImageFileInfo> g() {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getChosedFiles();
        }
        return null;
    }

    public String h() {
        return this.f63754e;
    }

    public List<ImageFileInfo> i() {
        return this.f63756g;
    }

    public int j() {
        List<ImageFileInfo> list;
        ImageFileInfo imageFileInfo = this.f63755f;
        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (list = this.f63756g) != null && list.size() != 0) {
            int size = this.f63756g.size();
            for (int i = 0; i < size; i++) {
                ImageFileInfo imageFileInfo2 = this.f63756g.get(i);
                if (imageFileInfo2 != null && this.f63755f.getFilePath().equals(imageFileInfo2.getFilePath())) {
                    return i;
                }
            }
        }
        return 0;
    }

    public String k() {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getLastAlbumId();
        }
        return null;
    }

    public int l() {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getMaxImagesAllowed();
        }
        return 0;
    }

    public WriteImagesInfo m() {
        return this.f63752c;
    }

    public boolean n(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo == null) {
            return false;
        }
        return writeImagesInfo.isAdded(imageFileInfo);
    }

    public boolean o() {
        return !ListUtils.isEmpty(g());
    }

    public boolean p() {
        return this.f63753d != null;
    }

    public boolean q(VideoFileInfo videoFileInfo) {
        VideoFileInfo videoFileInfo2 = this.f63753d;
        return (videoFileInfo2 == null || videoFileInfo == null || videoFileInfo2.videoId != videoFileInfo.videoId) ? false : true;
    }

    public boolean r() {
        return ListUtils.isEmpty(d(d.b.i0.e.a.f50849f));
    }

    public boolean s() {
        WriteImagesInfo writeImagesInfo = this.f63752c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.isOriginalImg();
        }
        return false;
    }

    public d.b.i0.e.a t(List<MediaFileInfo> list) {
        d.b.i0.e.a aVar = new d.b.i0.e.a();
        aVar.h(d.b.i0.e.a.f50849f);
        aVar.l(this.f63751b.getString(R.string.album_all_media));
        int count = ListUtils.getCount(list);
        aVar.j(list);
        aVar.i(String.valueOf(count));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(list, count - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.k((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.k((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public d.b.i0.e.a u(List<VideoFileInfo> list) {
        d.b.i0.e.a aVar = new d.b.i0.e.a();
        aVar.h(d.b.i0.e.a.f50850g);
        aVar.l(this.f63751b.getString(R.string.album_all_video));
        int count = ListUtils.getCount(list);
        aVar.i(String.valueOf(count));
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            arrayList.addAll(list);
        }
        aVar.j(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) ListUtils.getItem(list, count - 1);
        if (videoFileInfo != null) {
            aVar.k(videoFileInfo);
        }
        return aVar;
    }

    public final void v(String str) {
        if (this.f63757h == null || StringUtils.isNull(str)) {
            return;
        }
        for (d.b.i0.e.a aVar : this.f63757h) {
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                ArrayList arrayList = new ArrayList();
                if (aVar.d() != null) {
                    for (MediaFileInfo mediaFileInfo : aVar.d()) {
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            arrayList.add((ImageFileInfo) mediaFileInfo);
                        }
                    }
                }
                this.f63756g = arrayList;
            }
        }
    }

    public void w(VideoFileInfo videoFileInfo) {
        this.f63753d = videoFileInfo;
    }

    public void x(String str) {
        this.f63754e = str;
        v(str);
    }

    public void y(ImageFileInfo imageFileInfo) {
        this.f63755f = imageFileInfo;
    }

    public void z(d.b.i0.e.g gVar) {
        if (gVar == null) {
            return;
        }
        List<MediaFileInfo> list = gVar.f50881b;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(list));
        if (!ListUtils.isEmpty(gVar.f50882c)) {
            arrayList.add(u(gVar.f50882c));
        }
        if (!ListUtils.isEmpty(gVar.f50880a)) {
            arrayList.addAll(gVar.f50880a);
        }
        this.f63757h.clear();
        this.f63757h.addAll(arrayList);
    }
}
