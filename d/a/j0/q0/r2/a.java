package d.a.j0.q0.r2;

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
public class a extends d.a.i0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f58648a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58649b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f58650c;

    /* renamed from: d  reason: collision with root package name */
    public C1458a f58651d;

    /* renamed from: e  reason: collision with root package name */
    public f f58652e;

    /* renamed from: f  reason: collision with root package name */
    public View f58653f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58654g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58655h;

    /* renamed from: d.a.j0.q0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1458a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f58656e;

        /* renamed from: d.a.j0.q0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1459a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58658e;

            public View$OnClickListenerC1459a(int i2) {
                this.f58658e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1458a.this.getItem(this.f58658e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f58652e.getContext()).createNormalCfg(C1458a.this.getItem(this.f58658e).forum_name, null)));
            }
        }

        public C1458a(List<RecmForumInfo> list) {
            this.f58656e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            return this.f58656e.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f58656e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f58652e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f58665f = view.findViewById(R.id.root_view);
                bVar.f58660a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f58662c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f58661b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f58663d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f58664e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f58666g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f58667h = (TextView) view.findViewById(R.id.thread_title);
                bVar.f58668i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i2) != null) {
                bVar.f58660a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f58664e.V(getItem(i2).avatar, 10, false);
                bVar.f58662c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                bVar.f58661b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                bVar.f58665f.setOnClickListener(new View$OnClickListenerC1459a(i2));
                SkinManager.setViewTextColor(bVar.f58660a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f58662c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58661b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58667h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58666g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.f58668i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f58663d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58660a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58661b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58662c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f58663d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f58664e;

        /* renamed from: f  reason: collision with root package name */
        public View f58665f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58666g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f58667h;

        /* renamed from: i  reason: collision with root package name */
        public View f58668i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f58652e = fVar;
        this.f58648a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f58649b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f58653f = this.attachedView.findViewById(R.id.divider);
        this.f58650c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f58654g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f58655h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1458a c1458a = new C1458a(list);
        this.f58651d = c1458a;
        this.f58650c.setAdapter((ListAdapter) c1458a);
    }

    public void c(String str) {
        if (str == null) {
            this.f58649b.setVisibility(8);
            return;
        }
        this.f58649b.setVisibility(0);
        this.f58649b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f58648a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f58649b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f58653f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f58654g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f58655h, R.color.CAM_X0106, 1, skinType);
            C1458a c1458a = this.f58651d;
            if (c1458a != null) {
                c1458a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.i0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.i0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f58648a.setImageResource(0);
    }
}
