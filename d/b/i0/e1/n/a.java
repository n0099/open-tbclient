package d.b.i0.e1.n;

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
    public PersonalGroupFragment f55453e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f55454f = new ArrayList();

    /* renamed from: d.b.i0.e1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1268a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f55455a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f55456b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55457c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f55458d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f55459e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f55460f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f55461g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f55462h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f55453e = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 3) {
            i = 3;
        }
        for (int i2 = 1; i2 <= 3; i2++) {
            if (i2 <= i) {
                imageViewArr[i2].setVisibility(0);
            } else {
                imageViewArr[i2].setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.f55454f.size()) {
            return null;
        }
        return this.f55454f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f55454f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f55454f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1268a c1268a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1268a)) {
            c1268a = (C1268a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f55453e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1268a = new C1268a();
            c1268a.f55455a = (LinearLayout) view.findViewById(R.id.click_head);
            c1268a.f55461g = (ImageView) view.findViewById(R.id.diver_top);
            c1268a.f55462h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1268a.i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1268a.f55456b = (GroupImageView) view.findViewById(R.id.item_head);
            c1268a.f55457c = (TextView) view.findViewById(R.id.item_group_name);
            c1268a.f55458d = (TextView) view.findViewById(R.id.item_group_num);
            c1268a.f55459e = (TextView) view.findViewById(R.id.item_introduce);
            c1268a.f55460f = (TextView) view.findViewById(R.id.isCreator);
            c1268a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1268a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1268a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1268a.m = imageViewArr;
            imageViewArr[1] = c1268a.j;
            imageViewArr[2] = c1268a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1268a);
        }
        GroupInfoData groupInfoData = this.f55454f.get(i);
        c1268a.f55456b.setTag(null);
        c1268a.f55456b.setDrawBorder(true);
        c1268a.f55456b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1268a.f55456b.W(portrait, 10, false);
            } else {
                c1268a.f55456b.W("", 10, false);
            }
            c1268a.f55455a.setOnClickListener(this.f55453e);
            c1268a.f55455a.setTag(groupInfoData);
            c1268a.f55461g.setVisibility(8);
            c1268a.i.setVisibility(8);
            c1268a.f55462h.setVisibility(0);
            c1268a.f55457c.setText(groupInfoData.getName());
            TextView textView = c1268a.f55458d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1268a.f55459e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1268a.f55460f.setVisibility(0);
            } else {
                c1268a.f55460f.setVisibility(8);
            }
            a(c1268a.m, groupInfoData.getGrade());
        }
        this.f55453e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f55453e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1268a.f55457c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1268a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1268a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1268a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
