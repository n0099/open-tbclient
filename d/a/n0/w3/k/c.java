package d.a.n0.w3.k;

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
    public final d.a.c.a.f f66530b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f66531c;

    /* renamed from: d  reason: collision with root package name */
    public VideoFileInfo f66532d;

    /* renamed from: e  reason: collision with root package name */
    public String f66533e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo f66534f;

    /* renamed from: g  reason: collision with root package name */
    public List<ImageFileInfo> f66535g;

    /* renamed from: a  reason: collision with root package name */
    public int f66529a = 9;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.a.m0.e.a> f66536h = new ArrayList();

    public c(d.a.c.a.f fVar) {
        this.f66530b = fVar;
    }

    public void A(String str) {
        if (this.f66531c == null) {
            this.f66531c = new WriteImagesInfo(this.f66529a);
        }
        this.f66531c.setLastAlbumId(str);
    }

    public void B(boolean z) {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo != null) {
            writeImagesInfo.setOriginalImg(z);
        }
    }

    public void C(WriteImagesInfo writeImagesInfo) {
        this.f66531c = writeImagesInfo;
    }

    public int D() {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo == null) {
            return 0;
        }
        return writeImagesInfo.size();
    }

    public void a(ImageFileInfo imageFileInfo) {
        if (this.f66531c == null) {
            this.f66531c = new WriteImagesInfo(this.f66529a);
        }
        this.f66531c.addChooseFile(imageFileInfo);
    }

    public void b() {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo == null) {
            return;
        }
        writeImagesInfo.clear();
    }

    public void c(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo == null) {
            return;
        }
        writeImagesInfo.delChooseFile(imageFileInfo);
    }

    public List<MediaFileInfo> d(String str) {
        if (this.f66536h != null && !StringUtils.isNull(str)) {
            for (d.a.m0.e.a aVar : this.f66536h) {
                if (aVar != null && TextUtils.equals(str, aVar.b())) {
                    return aVar.d();
                }
            }
        }
        return null;
    }

    public List<d.a.m0.e.a> e() {
        return this.f66536h;
    }

    public VideoFileInfo f() {
        return this.f66532d;
    }

    public List<ImageFileInfo> g() {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getChosedFiles();
        }
        return null;
    }

    public String h() {
        return this.f66533e;
    }

    public List<ImageFileInfo> i() {
        return this.f66535g;
    }

    public int j() {
        List<ImageFileInfo> list;
        ImageFileInfo imageFileInfo = this.f66534f;
        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (list = this.f66535g) != null && list.size() != 0) {
            int size = this.f66535g.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImageFileInfo imageFileInfo2 = this.f66535g.get(i2);
                if (imageFileInfo2 != null && this.f66534f.getFilePath().equals(imageFileInfo2.getFilePath())) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public String k() {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getLastAlbumId();
        }
        return null;
    }

    public int l() {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getMaxImagesAllowed();
        }
        return 0;
    }

    public WriteImagesInfo m() {
        return this.f66531c;
    }

    public boolean n(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo == null) {
            return false;
        }
        return writeImagesInfo.isAdded(imageFileInfo);
    }

    public boolean o() {
        return !ListUtils.isEmpty(g());
    }

    public boolean p() {
        return this.f66532d != null;
    }

    public boolean q(VideoFileInfo videoFileInfo) {
        VideoFileInfo videoFileInfo2 = this.f66532d;
        return (videoFileInfo2 == null || videoFileInfo == null || videoFileInfo2.videoId != videoFileInfo.videoId) ? false : true;
    }

    public boolean r() {
        return ListUtils.isEmpty(d(d.a.m0.e.a.f52973f));
    }

    public boolean s() {
        WriteImagesInfo writeImagesInfo = this.f66531c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.isOriginalImg();
        }
        return false;
    }

    public d.a.m0.e.a t(List<MediaFileInfo> list) {
        d.a.m0.e.a aVar = new d.a.m0.e.a();
        aVar.h(d.a.m0.e.a.f52973f);
        aVar.l(this.f66530b.getString(R.string.album_all_media));
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

    public d.a.m0.e.a u(List<VideoFileInfo> list) {
        d.a.m0.e.a aVar = new d.a.m0.e.a();
        aVar.h(d.a.m0.e.a.f52974g);
        aVar.l(this.f66530b.getString(R.string.album_all_video));
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
        if (this.f66536h == null || StringUtils.isNull(str)) {
            return;
        }
        for (d.a.m0.e.a aVar : this.f66536h) {
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                ArrayList arrayList = new ArrayList();
                if (aVar.d() != null) {
                    for (MediaFileInfo mediaFileInfo : aVar.d()) {
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            arrayList.add((ImageFileInfo) mediaFileInfo);
                        }
                    }
                }
                this.f66535g = arrayList;
            }
        }
    }

    public void w(VideoFileInfo videoFileInfo) {
        this.f66532d = videoFileInfo;
    }

    public void x(String str) {
        this.f66533e = str;
        v(str);
    }

    public void y(ImageFileInfo imageFileInfo) {
        this.f66534f = imageFileInfo;
    }

    public void z(d.a.m0.e.g gVar) {
        if (gVar == null) {
            return;
        }
        List<MediaFileInfo> list = gVar.f53005b;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(list));
        if (!ListUtils.isEmpty(gVar.f53006c)) {
            arrayList.add(u(gVar.f53006c));
        }
        if (!ListUtils.isEmpty(gVar.f53004a)) {
            arrayList.addAll(gVar.f53004a);
        }
        this.f66536h.clear();
        this.f66536h.addAll(arrayList);
    }
}
