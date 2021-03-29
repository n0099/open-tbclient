package d.b.i0.q1.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<BubbleListData.BubbleData> f59265e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<BubbleChooseActivity> f59266f;

    /* renamed from: g  reason: collision with root package name */
    public int f59267g;

    /* renamed from: h  reason: collision with root package name */
    public int f59268h;
    public boolean i;

    public a(TbPageContext<BubbleChooseActivity> tbPageContext) {
        this.f59266f = tbPageContext;
        this.f59267g = (int) tbPageContext.getResources().getDimension(R.dimen.ds30);
        this.f59268h = (int) this.f59266f.getResources().getDimension(R.dimen.ds30);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BubbleListData.BubbleData getItem(int i) {
        List<BubbleListData.BubbleData> list = this.f59265e;
        if (list != null) {
            if (i >= 0 || i < list.size()) {
                return this.f59265e.get(i);
            }
            return null;
        }
        return null;
    }

    public List<BubbleListData.BubbleData> b() {
        return this.f59265e;
    }

    public void c(List<BubbleListData.BubbleData> list) {
        this.f59265e.clear();
        BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
        bubbleData.setBcode(0);
        this.f59265e.add(bubbleData);
        this.f59265e.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.i = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BubbleListData.BubbleData> list = this.f59265e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BubbleView bubbleView;
        BubbleView bubbleView2;
        if (view == null) {
            bubbleView2 = new BubbleView(this.f59266f.getPageActivity());
            bubbleView = bubbleView2;
        } else {
            bubbleView = view;
            bubbleView2 = (BubbleView) view;
        }
        if (i == 0 || i == 1) {
            bubbleView2.setPadding(0, this.f59268h, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i == getCount() - 1 || i == getCount() - 2) {
                bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f59267g);
            }
        } else if (i == getCount() - 1) {
            bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f59267g);
        }
        BubbleListData.BubbleData item = getItem(i);
        if (item != null) {
            bubbleView2.setShowName(true);
            bubbleView2.setData(item, this.i);
        }
        bubbleView2.a(this.f59266f);
        return bubbleView;
    }
}
