package d.a.n0.f1.n;

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
    public PersonalGroupFragment f54634e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f54635f = new ArrayList();

    /* renamed from: d.a.n0.f1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1320a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f54636a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f54637b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54638c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f54639d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54640e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f54641f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f54642g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f54643h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f54644i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f54634e = personalGroupFragment;
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
        if (itemId < 0 || itemId >= this.f54635f.size()) {
            return null;
        }
        return this.f54635f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f54635f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f54635f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1320a c1320a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1320a)) {
            c1320a = (C1320a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f54634e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1320a = new C1320a();
            c1320a.f54636a = (LinearLayout) view.findViewById(R.id.click_head);
            c1320a.f54642g = (ImageView) view.findViewById(R.id.diver_top);
            c1320a.f54643h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1320a.f54644i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1320a.f54637b = (GroupImageView) view.findViewById(R.id.item_head);
            c1320a.f54638c = (TextView) view.findViewById(R.id.item_group_name);
            c1320a.f54639d = (TextView) view.findViewById(R.id.item_group_num);
            c1320a.f54640e = (TextView) view.findViewById(R.id.item_introduce);
            c1320a.f54641f = (TextView) view.findViewById(R.id.isCreator);
            c1320a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1320a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1320a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1320a.m = imageViewArr;
            imageViewArr[1] = c1320a.j;
            imageViewArr[2] = c1320a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1320a);
        }
        GroupInfoData groupInfoData = this.f54635f.get(i2);
        c1320a.f54637b.setTag(null);
        c1320a.f54637b.setDrawBorder(true);
        c1320a.f54637b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1320a.f54637b.V(portrait, 10, false);
            } else {
                c1320a.f54637b.V("", 10, false);
            }
            c1320a.f54636a.setOnClickListener(this.f54634e);
            c1320a.f54636a.setTag(groupInfoData);
            c1320a.f54642g.setVisibility(8);
            c1320a.f54644i.setVisibility(8);
            c1320a.f54643h.setVisibility(0);
            c1320a.f54638c.setText(groupInfoData.getName());
            TextView textView = c1320a.f54639d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1320a.f54640e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1320a.f54641f.setVisibility(0);
            } else {
                c1320a.f54641f.setVisibility(8);
            }
            a(c1320a.m, groupInfoData.getGrade());
        }
        this.f54634e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f54634e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1320a.f54638c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1320a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1320a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1320a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
