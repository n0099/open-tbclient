package d.a.o0.w3.k;

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
    public String f66639a;

    /* renamed from: b  reason: collision with root package name */
    public String f66640b;

    /* renamed from: c  reason: collision with root package name */
    public e f66641c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f66642d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f66643e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f66644f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f66645g;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.f66639a = "tag_image";
        this.f66640b = "tag_b_image";
        this.f66641c = eVar;
    }

    public View d() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f66645g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.S0();
    }

    public View e() {
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.X0();
    }

    public View f() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f66645g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.T0();
    }

    public View h() {
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Y0();
    }

    public TbCameraView i() {
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.Z0();
    }

    public Fragment k(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f66642d[i2];
    }

    public String l(int i2) {
        if (i2 < 0 || i2 > 1) {
            return null;
        }
        return this.f66643e[i2];
    }

    public ImageListFragment m() {
        return this.f66644f;
    }

    public View n() {
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment == null) {
            return null;
        }
        return imageListFragment.b1();
    }

    public View o() {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f66645g;
        if (albumImageBrowseFragment == null) {
            return null;
        }
        return albumImageBrowseFragment.U0();
    }

    public void onChangeSkinType(int i2) {
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f66642d;
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
        this.f66642d = new Fragment[2];
        this.f66643e = new String[2];
        ImageListFragment imageListFragment = new ImageListFragment();
        this.f66644f = imageListFragment;
        imageListFragment.h1(this.f66641c);
        this.f66642d[0] = this.f66644f;
        this.f66643e[0] = this.f66639a;
        AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
        this.f66645g = albumImageBrowseFragment;
        albumImageBrowseFragment.Z0(this.f66641c);
        this.f66642d[1] = this.f66645g;
        this.f66643e[1] = this.f66640b;
    }

    public void q() {
    }

    public void r() {
        TbCameraView i2 = i();
        if (i2 != null) {
            i2.setVisibility(0);
            i2.k(false);
        }
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment == null || imageListFragment.a1() == null) {
            return;
        }
        this.f66644f.a1().n();
    }

    public void s() {
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment != null) {
            imageListFragment.c1();
        }
    }

    public void t(boolean z) {
        AlbumImageBrowseFragment albumImageBrowseFragment = this.f66645g;
        if (albumImageBrowseFragment != null) {
            albumImageBrowseFragment.Y0(z);
        }
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment != null) {
            imageListFragment.g1(z);
        }
    }

    public void u(NavigationBar navigationBar) {
        this.f66644f.i1(navigationBar);
    }

    public void v(j jVar) {
        ImageListFragment imageListFragment = this.f66644f;
        if (imageListFragment != null) {
            imageListFragment.j1(jVar);
        }
    }

    public void w() {
        TbCameraView i2 = i();
        if (i2 != null) {
            i2.m();
            i2.setVisibility(4);
        }
    }
}
