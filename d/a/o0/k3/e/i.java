package d.a.o0.k3.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f60845a;

    /* renamed from: b  reason: collision with root package name */
    public View f60846b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f60847c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f60848d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60849e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60850f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60851g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60852h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.e.l.c<d.a.c.k.d.a> f60853i = new a();

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public a() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null) {
                aVar.h(i.this.f60847c);
            }
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f60845a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f60846b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f60845a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        return this.f60846b;
    }

    public final void c() {
        this.f60847c = (BdExpandImageView) this.f60846b.findViewById(R.id.expand_image);
        this.f60848d = (TbImageView) this.f60846b.findViewById(R.id.user_head);
        TbImageView tbImageView = (TbImageView) this.f60846b.findViewById(R.id.vip_icon);
        this.f60849e = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f60850f = (TextView) this.f60846b.findViewById(R.id.user_name);
        this.f60851g = (ImageView) this.f60846b.findViewById(R.id.user_sex);
        this.f60852h = (TextView) this.f60846b.findViewById(R.id.user_bar_age_num);
        this.f60848d.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void d() {
        if (this.f60845a.getPageContext() == null) {
            return;
        }
        d.a.n0.s0.a.a(this.f60845a.getPageContext(), this.f60846b);
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        d.a.c.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f60853i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f60852h.setText("0");
        } else {
            this.f60852h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f60852h, R.color.CAM_X0308, 1);
            this.f60850f.setText(R.string.default_user_name);
            this.f60851g.setImageResource(R.drawable.icon_pop_boy);
            this.f60849e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f60848d.U(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f60849e.setVisibility(8);
        } else {
            this.f60849e.U(memberIconUrl, 10, false);
            this.f60849e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f60850f.setTextColor(this.f60845a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f60850f.setTextColor(this.f60845a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f60850f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f60851g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f60851g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f60851g.setVisibility(8);
        }
    }
}
