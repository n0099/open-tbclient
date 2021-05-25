package d.a.n0.p;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.R;
import d.a.m0.r.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f57918e;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57921h;

    /* renamed from: g  reason: collision with root package name */
    public List<AccountData> f57920g = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57919f = false;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57922a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57923b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f57924c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57925d;

        public b(a aVar) {
        }
    }

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f57918e = baseActivity;
        this.f57921h = onClickListener;
    }

    public boolean a() {
        return this.f57919f;
    }

    public void b(List<AccountData> list) {
        this.f57920g = list;
    }

    public void c(boolean z) {
        this.f57919f = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<AccountData> list = this.f57920g;
        return (list != null ? list.size() : 0) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<AccountData> list = this.f57920g;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f57920g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (getItem(i2) != null) {
            return i2;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return getItemId(i2) >= 0 ? 0 : 1;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, CONST, INVOKE, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ca, code lost:
        if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getSkinType() == 1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e1, code lost:
        if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getSkinType() != 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e4, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e5, code lost:
        r6.k(r0);
        r5.f57918e.getLayoutMode().j(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f1, code lost:
        return r7;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c layoutMode;
        b bVar;
        try {
            try {
                if (view == null) {
                    if (getItemViewType(i2) == 0) {
                        view = LayoutInflater.from(this.f57918e.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                        bVar = new b();
                        bVar.f57922a = (TextView) view.findViewById(R.id.account);
                        bVar.f57924c = (ImageView) view.findViewById(R.id.active);
                        TextView textView = (TextView) view.findViewById(R.id.delete);
                        bVar.f57925d = textView;
                        textView.setOnClickListener(this.f57921h);
                        view.setTag(bVar);
                    } else {
                        view = LayoutInflater.from(this.f57918e.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                        bVar = new b();
                        bVar.f57923b = (TextView) view.findViewById(R.id.add_text);
                        view.setTag(bVar);
                    }
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItemViewType(i2) == 0) {
                    AccountData accountData = (AccountData) getItem(i2);
                    bVar.f57924c.setVisibility(8);
                    bVar.f57925d.setVisibility(8);
                    bVar.f57925d.setTag(accountData);
                    if (accountData != null) {
                        bVar.f57922a.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            bVar.f57924c.setVisibility(0);
                        }
                        if (this.f57919f) {
                            bVar.f57925d.setVisibility(0);
                        }
                    }
                }
                layoutMode = this.f57918e.getLayoutMode();
            } catch (Exception e2) {
                BdLog.detailException(e2);
                layoutMode = this.f57918e.getLayoutMode();
            }
        } catch (Throwable th) {
            this.f57918e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f57918e.getLayoutMode().j(view);
            throw th;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
