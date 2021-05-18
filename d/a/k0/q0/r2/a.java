package d.a.k0.q0.r2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends d.a.j0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f59390a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59391b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f59392c;

    /* renamed from: d  reason: collision with root package name */
    public C1532a f59393d;

    /* renamed from: e  reason: collision with root package name */
    public f f59394e;

    /* renamed from: f  reason: collision with root package name */
    public View f59395f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59396g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59397h;

    /* renamed from: d.a.k0.q0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1532a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f59398e;

        /* renamed from: d.a.k0.q0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1533a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59400e;

            public View$OnClickListenerC1533a(int i2) {
                this.f59400e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1532a.this.getItem(this.f59400e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f59394e.getContext()).createNormalCfg(C1532a.this.getItem(this.f59400e).forum_name, null)));
            }
        }

        public C1532a(List<RecmForumInfo> list) {
            this.f59398e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            return this.f59398e.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f59398e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f59394e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f59407f = view.findViewById(R.id.root_view);
                bVar.f59402a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f59404c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f59403b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f59405d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f59406e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f59408g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f59409h = (TextView) view.findViewById(R.id.thread_title);
                bVar.f59410i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i2) != null) {
                bVar.f59402a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f59406e.V(getItem(i2).avatar, 10, false);
                bVar.f59404c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                bVar.f59403b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                bVar.f59407f.setOnClickListener(new View$OnClickListenerC1533a(i2));
                SkinManager.setViewTextColor(bVar.f59402a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f59404c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f59403b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f59409h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f59408g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.f59410i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f59405d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59402a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59403b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59404c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f59405d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f59406e;

        /* renamed from: f  reason: collision with root package name */
        public View f59407f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59408g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f59409h;

        /* renamed from: i  reason: collision with root package name */
        public View f59410i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f59394e = fVar;
        this.f59390a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f59391b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f59395f = this.attachedView.findViewById(R.id.divider);
        this.f59392c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f59396g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f59397h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1532a c1532a = new C1532a(list);
        this.f59393d = c1532a;
        this.f59392c.setAdapter((ListAdapter) c1532a);
    }

    public void c(String str) {
        if (str == null) {
            this.f59391b.setVisibility(8);
            return;
        }
        this.f59391b.setVisibility(0);
        this.f59391b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f59390a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f59391b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f59395f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f59396g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f59397h, R.color.CAM_X0106, 1, skinType);
            C1532a c1532a = this.f59393d;
            if (c1532a != null) {
                c1532a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.j0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.j0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f59390a.setImageResource(0);
    }
}
