package d.a.n0.k3.e;

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
    public BackgroundPreviewActivity f60720a;

    /* renamed from: b  reason: collision with root package name */
    public View f60721b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f60722c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f60723d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60724e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60725f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60726g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60727h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.e.l.c<d.a.c.k.d.a> f60728i = new a();

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
                aVar.h(i.this.f60722c);
            }
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f60720a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f60721b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f60720a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        return this.f60721b;
    }

    public final void c() {
        this.f60722c = (BdExpandImageView) this.f60721b.findViewById(R.id.expand_image);
        this.f60723d = (TbImageView) this.f60721b.findViewById(R.id.user_head);
        TbImageView tbImageView = (TbImageView) this.f60721b.findViewById(R.id.vip_icon);
        this.f60724e = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f60725f = (TextView) this.f60721b.findViewById(R.id.user_name);
        this.f60726g = (ImageView) this.f60721b.findViewById(R.id.user_sex);
        this.f60727h = (TextView) this.f60721b.findViewById(R.id.user_bar_age_num);
        this.f60723d.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void d() {
        if (this.f60720a.getPageContext() == null) {
            return;
        }
        d.a.m0.s0.a.a(this.f60720a.getPageContext(), this.f60721b);
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        d.a.c.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f60728i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f60727h.setText("0");
        } else {
            this.f60727h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f60727h, R.color.CAM_X0308, 1);
            this.f60725f.setText(R.string.default_user_name);
            this.f60726g.setImageResource(R.drawable.icon_pop_boy);
            this.f60724e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f60723d.U(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f60724e.setVisibility(8);
        } else {
            this.f60724e.U(memberIconUrl, 10, false);
            this.f60724e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f60725f.setTextColor(this.f60720a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f60725f.setTextColor(this.f60720a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f60725f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f60726g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f60726g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f60726g.setVisibility(8);
        }
    }
}
