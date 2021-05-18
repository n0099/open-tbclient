package d.a.k0.v3.k;

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
    public String f62692a;

    /* renamed from: b  reason: collision with root package name */
    public String f62693b;

    /* renamed from: c  reason: collision with root package name */
    public e f62694c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f62695d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f62696e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f62697f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f62698g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f62692a = "tag_image";
        this.f62693b = "tag_b_image";
        this.f62694c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62698g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.P0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.U0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62698g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.Q0();
    }

    public View g() {
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.V0();
    }

    public TbCameraView h() {
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.W0();
    }

    public Fragment j(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f62695d[i2];
    }

    public String k(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f62696e[i2];
    }

    public ImageListFragment l() {
        return this.f62697f;
    }

    public View m() {
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Y0();
    }

    public View n() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62698g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.R0();
    }

    public void o() {
        this.f62695d = new Fragment[2];
        this.f62696e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f62697f = imageListFragment;
        imageListFragment.e1(this.f62694c);
        this.f62695d[0] = this.f62697f;
        this.f62696e[0] = this.f62692a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f62698g = albumImageBrowseFragment;
        albumImageBrowseFragment.W0(this.f62694c);
        this.f62695d[1] = this.f62698g;
        this.f62696e[1] = this.f62693b;
    }

    public void onChangeSkinType(int i2) {
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f62695d;
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
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment == null || imageListFragment.X0() == null) {
            return;
        }
        this.f62697f.X0().n();
    }

    public void r() {
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment != null) {
            imageListFragment.Z0();
        }
    }

    public void s(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f62698g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.V0(z);
        }
        ImageListFragment imageListFragment = this.f62697f;
        if (imageListFragment != null) {
            imageListFragment.d1(z);
        }
    }

    public void t(NavigationBar navigationBar) {
        this.f62697f.f1(navigationBar);
    }

    public void u(j jVar) {
        ImageListFragment imageListFragment = this.f62697f;
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
