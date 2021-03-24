package d.b.i0.n;

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
import d.b.h0.r.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f56958e;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56961h;

    /* renamed from: g  reason: collision with root package name */
    public List<AccountData> f56960g = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56959f = false;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56962a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56963b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f56964c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f56965d;

        public b(a aVar) {
        }
    }

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f56958e = baseActivity;
        this.f56961h = onClickListener;
    }

    public boolean a() {
        return this.f56959f;
    }

    public void b(List<AccountData> list) {
        this.f56960g = list;
    }

    public void c(boolean z) {
        this.f56959f = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<AccountData> list = this.f56960g;
        return (list != null ? list.size() : 0) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<AccountData> list = this.f56960g;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f56960g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
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
        r5.f56958e.getLayoutMode().j(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f1, code lost:
        return r7;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        c layoutMode;
        b bVar;
        try {
            try {
                if (view == null) {
                    if (getItemViewType(i) == 0) {
                        view = LayoutInflater.from(this.f56958e.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                        bVar = new b();
                        bVar.f56962a = (TextView) view.findViewById(R.id.account);
                        bVar.f56964c = (ImageView) view.findViewById(R.id.active);
                        TextView textView = (TextView) view.findViewById(R.id.delete);
                        bVar.f56965d = textView;
                        textView.setOnClickListener(this.f56961h);
                        view.setTag(bVar);
                    } else {
                        view = LayoutInflater.from(this.f56958e.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                        bVar = new b();
                        bVar.f56963b = (TextView) view.findViewById(R.id.add_text);
                        view.setTag(bVar);
                    }
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    bVar.f56964c.setVisibility(8);
                    bVar.f56965d.setVisibility(8);
                    bVar.f56965d.setTag(accountData);
                    if (accountData != null) {
                        bVar.f56962a.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            bVar.f56964c.setVisibility(0);
                        }
                        if (this.f56959f) {
                            bVar.f56965d.setVisibility(0);
                        }
                    }
                }
                layoutMode = this.f56958e.getLayoutMode();
            } catch (Exception e2) {
                BdLog.detailException(e2);
                layoutMode = this.f56958e.getLayoutMode();
            }
        } catch (Throwable th) {
            this.f56958e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f56958e.getLayoutMode().j(view);
            throw th;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
