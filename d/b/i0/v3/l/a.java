package d.b.i0.v3.l;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes5.dex */
public class a extends d.b.c.a.d<BaseFragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    public String f63315a;

    /* renamed from: b  reason: collision with root package name */
    public String f63316b;

    /* renamed from: c  reason: collision with root package name */
    public e f63317c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f63318d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f63319e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f63320f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f63321g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f63315a = "tag_image";
        this.f63316b = "tag_b_image";
        this.f63317c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63321g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.Q0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.V0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63321g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.R0();
    }

    public View h() {
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.W0();
    }

    public TbCameraView i() {
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.X0();
    }

    public Fragment k(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.f63318d[i];
    }

    public String l(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.f63319e[i];
    }

    public ImageListFragment m() {
        return this.f63320f;
    }

    public View n() {
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Z0();
    }

    public View o() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63321g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.S0();
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f63318d;
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
        this.f63318d = new Fragment[2];
        this.f63319e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f63320f = imageListFragment;
        imageListFragment.f1(this.f63317c);
        this.f63318d[0] = this.f63320f;
        this.f63319e[0] = this.f63315a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f63321g = albumImageBrowseFragment;
        albumImageBrowseFragment.X0(this.f63317c);
        this.f63318d[1] = this.f63321g;
        this.f63319e[1] = this.f63316b;
    }

    public void r() {
    }

    public void s() {
        TbCameraView i = i();
        if (i != null) {
            i.setVisibility(0);
            i.k(false);
        }
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment == null || imageListFragment.Y0() == null) {
            return;
        }
        this.f63320f.Y0().n();
    }

    public void u() {
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment != null) {
            imageListFragment.a1();
        }
    }

    public void v(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63321g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.W0(z);
        }
        ImageListFragment imageListFragment = this.f63320f;
        if (imageListFragment != null) {
            imageListFragment.e1(z);
        }
    }

    public void w(NavigationBar navigationBar) {
        this.f63320f.g1(navigationBar);
    }

    public void x(j jVar) {
        ImageListFragment imageListFragment = this.f63320f;
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
