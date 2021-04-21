package d.b.j0.v3.l;

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
    public String f63736a;

    /* renamed from: b  reason: collision with root package name */
    public String f63737b;

    /* renamed from: c  reason: collision with root package name */
    public e f63738c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f63739d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f63740e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f63741f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f63742g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f63736a = "tag_image";
        this.f63737b = "tag_b_image";
        this.f63738c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63742g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.Q0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.V0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63742g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.R0();
    }

    public View h() {
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.W0();
    }

    public TbCameraView i() {
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.X0();
    }

    public Fragment k(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.f63739d[i];
    }

    public String l(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.f63740e[i];
    }

    public ImageListFragment m() {
        return this.f63741f;
    }

    public View n() {
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Z0();
    }

    public View o() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63742g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.S0();
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f63739d;
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
        this.f63739d = new Fragment[2];
        this.f63740e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f63741f = imageListFragment;
        imageListFragment.f1(this.f63738c);
        this.f63739d[0] = this.f63741f;
        this.f63740e[0] = this.f63736a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f63742g = albumImageBrowseFragment;
        albumImageBrowseFragment.X0(this.f63738c);
        this.f63739d[1] = this.f63742g;
        this.f63740e[1] = this.f63737b;
    }

    public void r() {
    }

    public void s() {
        TbCameraView i = i();
        if (i != null) {
            i.setVisibility(0);
            i.k(false);
        }
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment == null || imageListFragment.Y0() == null) {
            return;
        }
        this.f63741f.Y0().n();
    }

    public void u() {
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment != null) {
            imageListFragment.a1();
        }
    }

    public void v(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f63742g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.W0(z);
        }
        ImageListFragment imageListFragment = this.f63741f;
        if (imageListFragment != null) {
            imageListFragment.e1(z);
        }
    }

    public void w(NavigationBar navigationBar) {
        this.f63741f.g1(navigationBar);
    }

    public void x(j jVar) {
        ImageListFragment imageListFragment = this.f63741f;
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
