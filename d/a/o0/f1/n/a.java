package d.a.o0.f1.n;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.mygroup.PersonalGroupFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f58448e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f58449f = new ArrayList();

    /* renamed from: d.a.o0.f1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1380a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f58450a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f58451b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58452c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58453d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58454e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f58455f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f58456g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f58457h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f58458i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f58448e = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i2) {
        int itemId = (int) getItemId(i2);
        if (itemId < 0 || itemId >= this.f58449f.size()) {
            return null;
        }
        return this.f58449f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f58449f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f58449f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1380a c1380a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1380a)) {
            c1380a = (C1380a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f58448e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1380a = new C1380a();
            c1380a.f58450a = (LinearLayout) view.findViewById(R.id.click_head);
            c1380a.f58456g = (ImageView) view.findViewById(R.id.diver_top);
            c1380a.f58457h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1380a.f58458i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1380a.f58451b = (GroupImageView) view.findViewById(R.id.item_head);
            c1380a.f58452c = (TextView) view.findViewById(R.id.item_group_name);
            c1380a.f58453d = (TextView) view.findViewById(R.id.item_group_num);
            c1380a.f58454e = (TextView) view.findViewById(R.id.item_introduce);
            c1380a.f58455f = (TextView) view.findViewById(R.id.isCreator);
            c1380a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1380a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1380a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1380a.m = imageViewArr;
            imageViewArr[1] = c1380a.j;
            imageViewArr[2] = c1380a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1380a);
        }
        GroupInfoData groupInfoData = this.f58449f.get(i2);
        c1380a.f58451b.setTag(null);
        c1380a.f58451b.setDrawBorder(true);
        c1380a.f58451b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1380a.f58451b.U(portrait, 10, false);
            } else {
                c1380a.f58451b.U("", 10, false);
            }
            c1380a.f58450a.setOnClickListener(this.f58448e);
            c1380a.f58450a.setTag(groupInfoData);
            c1380a.f58456g.setVisibility(8);
            c1380a.f58458i.setVisibility(8);
            c1380a.f58457h.setVisibility(0);
            c1380a.f58452c.setText(groupInfoData.getName());
            TextView textView = c1380a.f58453d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1380a.f58454e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1380a.f58455f.setVisibility(0);
            } else {
                c1380a.f58455f.setVisibility(8);
            }
            a(c1380a.m, groupInfoData.getGrade());
        }
        this.f58448e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58448e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1380a.f58452c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1380a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1380a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1380a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
