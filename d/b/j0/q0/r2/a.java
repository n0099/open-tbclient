package d.b.j0.q0.r2;

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
import d.b.c.a.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends d.b.i0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f60546a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60547b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f60548c;

    /* renamed from: d  reason: collision with root package name */
    public C1519a f60549d;

    /* renamed from: e  reason: collision with root package name */
    public f f60550e;

    /* renamed from: f  reason: collision with root package name */
    public View f60551f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60552g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60553h;

    /* renamed from: d.b.j0.q0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1519a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f60554e;

        /* renamed from: d.b.j0.q0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1520a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f60556e;

            public View$OnClickListenerC1520a(int i) {
                this.f60556e = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1519a.this.getItem(this.f60556e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f60550e.getContext()).createNormalCfg(C1519a.this.getItem(this.f60556e).forum_name, null)));
            }
        }

        public C1519a(List<RecmForumInfo> list) {
            this.f60554e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i) {
            return this.f60554e.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f60554e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f60550e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f60563f = view.findViewById(R.id.root_view);
                bVar.f60558a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f60560c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f60559b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f60561d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f60562e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f60564g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f60565h = (TextView) view.findViewById(R.id.thread_title);
                bVar.i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.f60558a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f60562e.W(getItem(i).avatar, 10, false);
                bVar.f60560c.setText(StringHelper.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.f60559b.setText(StringHelper.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.f60563f.setOnClickListener(new View$OnClickListenerC1520a(i));
                SkinManager.setViewTextColor(bVar.f60558a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f60560c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f60559b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f60565h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f60564g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f60561d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f60558a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60559b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60560c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f60561d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f60562e;

        /* renamed from: f  reason: collision with root package name */
        public View f60563f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60564g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f60565h;
        public View i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f60550e = fVar;
        this.f60546a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f60547b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f60551f = this.attachedView.findViewById(R.id.divider);
        this.f60548c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f60552g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f60553h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1519a c1519a = new C1519a(list);
        this.f60549d = c1519a;
        this.f60548c.setAdapter((ListAdapter) c1519a);
    }

    public void c(String str) {
        if (str == null) {
            this.f60547b.setVisibility(8);
            return;
        }
        this.f60547b.setVisibility(0);
        this.f60547b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f60546a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f60547b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f60551f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f60552g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f60553h, R.color.CAM_X0106, 1, skinType);
            C1519a c1519a = this.f60549d;
            if (c1519a != null) {
                c1519a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.b.i0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.b.i0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f60546a.setImageResource(0);
    }
}
