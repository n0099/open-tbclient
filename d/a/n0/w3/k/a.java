package d.a.n0.w3.k;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes5.dex */
public class a extends d.a.c.a.d<BaseFragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    public String f62799a;

    /* renamed from: b  reason: collision with root package name */
    public String f62800b;

    /* renamed from: c  reason: collision with root package name */
    public e f62801c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f62802d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f62803e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f62804f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f62805g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f62799a = "tag_image";
        this.f62800b = "tag_b_image";
        this.f62801c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62805g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.P0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.U0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62805g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.Q0();
    }

    public View g() {
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.V0();
    }

    public TbCameraView h() {
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.W0();
    }

    public Fragment j(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f62802d[i2];
    }

    public String k(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f62803e[i2];
    }

    public ImageListFragment l() {
        return this.f62804f;
    }

    public View m() {
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Y0();
    }

    public View n() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62805g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.R0();
    }

    public void o() {
        this.f62802d = new Fragment[2];
        this.f62803e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f62804f = imageListFragment;
        imageListFragment.e1(this.f62801c);
        this.f62802d[0] = this.f62804f;
        this.f62803e[0] = this.f62799a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f62805g = albumImageBrowseFragment;
        albumImageBrowseFragment.W0(this.f62801c);
        this.f62802d[1] = this.f62805g;
        this.f62803e[1] = this.f62800b;
    }

    public void onChangeSkinType(int i2) {
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f62802d;
            if (i3 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i3] != null && (fragmentArr[i3] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i3]).onChangeSkinType(i2);
            }
            i3++;
        }
    }

    public void p() {
    }

    public void q() {
        TbCameraView h2 = h();
        if (h2 != null) {
            h2.setVisibility(0);
            h2.k(false);
        }
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment == null || imageListFragment.X0() == null) {
            return;
        }
        this.f62804f.X0().n();
    }

    public void r() {
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment != null) {
            imageListFragment.Z0();
        }
    }

    public void s(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62805g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.V0(z);
        }
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment != null) {
            imageListFragment.d1(z);
        }
    }

    public void t(NavigationBar navigationBar) {
        this.f62804f.f1(navigationBar);
    }

    public void u(j jVar) {
        ImageListFragment imageListFragment = this.f62804f;
        if (imageListFragment != null) {
            imageListFragment.g1(jVar);
        }
    }

    public void v() {
        TbCameraView h2 = h();
        if (h2 != null) {
            h2.m();
            h2.setVisibility(4);
        }
    }
}
