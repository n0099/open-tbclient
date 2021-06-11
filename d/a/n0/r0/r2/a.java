package d.a.n0.r0.r2;

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
public class a extends d.a.m0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f63222a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63223b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63224c;

    /* renamed from: d  reason: collision with root package name */
    public C1601a f63225d;

    /* renamed from: e  reason: collision with root package name */
    public f f63226e;

    /* renamed from: f  reason: collision with root package name */
    public View f63227f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63228g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63229h;

    /* renamed from: d.a.n0.r0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1601a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f63230e;

        /* renamed from: d.a.n0.r0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1602a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f63232e;

            public View$OnClickListenerC1602a(int i2) {
                this.f63232e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1601a.this.getItem(this.f63232e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f63226e.getContext()).createNormalCfg(C1601a.this.getItem(this.f63232e).forum_name, null)));
            }
        }

        public C1601a(List<RecmForumInfo> list) {
            this.f63230e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            return this.f63230e.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f63230e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f63226e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f63239f = view.findViewById(R.id.root_view);
                bVar.f63234a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f63236c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f63235b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f63237d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f63238e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f63240g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f63241h = (TextView) view.findViewById(R.id.thread_title);
                bVar.f63242i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i2) != null) {
                bVar.f63234a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f63238e.U(getItem(i2).avatar, 10, false);
                bVar.f63236c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                bVar.f63235b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                bVar.f63239f.setOnClickListener(new View$OnClickListenerC1602a(i2));
                SkinManager.setViewTextColor(bVar.f63234a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f63236c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f63235b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f63241h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f63240g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.f63242i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f63237d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63234a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63235b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63236c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f63237d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f63238e;

        /* renamed from: f  reason: collision with root package name */
        public View f63239f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63240g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f63241h;

        /* renamed from: i  reason: collision with root package name */
        public View f63242i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f63226e = fVar;
        this.f63222a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f63223b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f63227f = this.attachedView.findViewById(R.id.divider);
        this.f63224c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f63228g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f63229h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1601a c1601a = new C1601a(list);
        this.f63225d = c1601a;
        this.f63224c.setAdapter((ListAdapter) c1601a);
    }

    public void c(String str) {
        if (str == null) {
            this.f63223b.setVisibility(8);
            return;
        }
        this.f63223b.setVisibility(0);
        this.f63223b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f63222a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f63223b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f63227f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f63228g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f63229h, R.color.CAM_X0106, 1, skinType);
            C1601a c1601a = this.f63225d;
            if (c1601a != null) {
                c1601a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f63222a.setImageResource(0);
    }
}
