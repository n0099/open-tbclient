package d.a.j0.v3.k;

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
    public String f61968a;

    /* renamed from: b  reason: collision with root package name */
    public String f61969b;

    /* renamed from: c  reason: collision with root package name */
    public e f61970c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f61971d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f61972e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f61973f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f61974g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f61968a = "tag_image";
        this.f61969b = "tag_b_image";
        this.f61970c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61974g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.Q0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.V0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61974g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.R0();
    }

    public View g() {
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.W0();
    }

    public TbCameraView h() {
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.X0();
    }

    public Fragment j(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f61971d[i2];
    }

    public String k(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f61972e[i2];
    }

    public ImageListFragment l() {
        return this.f61973f;
    }

    public View m() {
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Z0();
    }

    public View n() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61974g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.S0();
    }

    public void o() {
        this.f61971d = new Fragment[2];
        this.f61972e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f61973f = imageListFragment;
        imageListFragment.f1(this.f61970c);
        this.f61971d[0] = this.f61973f;
        this.f61972e[0] = this.f61968a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f61974g = albumImageBrowseFragment;
        albumImageBrowseFragment.X0(this.f61970c);
        this.f61971d[1] = this.f61974g;
        this.f61972e[1] = this.f61969b;
    }

    public void onChangeSkinType(int i2) {
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f61971d;
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
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment == null || imageListFragment.Y0() == null) {
            return;
        }
        this.f61973f.Y0().n();
    }

    public void r() {
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment != null) {
            imageListFragment.a1();
        }
    }

    public void s(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f61974g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.W0(z);
        }
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment != null) {
            imageListFragment.e1(z);
        }
    }

    public void t(NavigationBar navigationBar) {
        this.f61973f.g1(navigationBar);
    }

    public void u(j jVar) {
        ImageListFragment imageListFragment = this.f61973f;
        if (imageListFragment != null) {
            imageListFragment.h1(jVar);
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
