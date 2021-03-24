package d.b.i0.u3.l;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes5.dex */
public class a extends d.b.b.a.d<BaseFragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    public String f61576a;

    /* renamed from: b  reason: collision with root package name */
    public String f61577b;

    /* renamed from: c  reason: collision with root package name */
    public e f61578c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f61579d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f61580e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f61581f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f61582g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f61576a = "tag_image";
        this.f61577b = "tag_b_image";
        this.f61578c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61582g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.Q0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.V0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61582g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.R0();
    }

    public View h() {
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.W0();
    }

    public TbCameraView i() {
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.X0();
    }

    public Fragment k(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.f61579d[i];
    }

    public String l(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.f61580e[i];
    }

    public ImageListFragment m() {
        return this.f61581f;
    }

    public View n() {
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Z0();
    }

    public View o() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61582g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.S0();
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f61579d;
            if (i2 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i2] != null && (fragmentArr[i2] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i2]).onChangeSkinType(i);
            }
            i2++;
        }
    }

    public void q() {
        this.f61579d = new Fragment[2];
        this.f61580e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f61581f = imageListFragment;
        imageListFragment.f1(this.f61578c);
        this.f61579d[0] = this.f61581f;
        this.f61580e[0] = this.f61576a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f61582g = albumImageBrowseFragment;
        albumImageBrowseFragment.X0(this.f61578c);
        this.f61579d[1] = this.f61582g;
        this.f61580e[1] = this.f61577b;
    }

    public void r() {
    }

    public void s() {
        TbCameraView i = i();
        if (i != null) {
            i.setVisibility(0);
            i.k(false);
        }
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment == null || imageListFragment.Y0() == null) {
            return;
        }
        this.f61581f.Y0().n();
    }

    public void u() {
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment != null) {
            imageListFragment.a1();
        }
    }

    public void v(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61582g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.W0(z);
        }
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment != null) {
            imageListFragment.e1(z);
        }
    }

    public void w(NavigationBar navigationBar) {
        this.f61581f.g1(navigationBar);
    }

    public void x(j jVar) {
        ImageListFragment imageListFragment = this.f61581f;
        if (imageListFragment != null) {
            imageListFragment.h1(jVar);
        }
    }

    public void y() {
        TbCameraView i = i();
        if (i != null) {
            i.m();
            i.setVisibility(4);
        }
    }
}
