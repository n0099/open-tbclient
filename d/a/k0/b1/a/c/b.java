package d.a.k0.b1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f52155a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f52156b;

    public b(AbsHListView absHListView) {
        this.f52156b = absHListView;
    }

    @Override // d.a.k0.b1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i2, long j, boolean z) {
        this.f52155a.a(actionMode, i2, j, z);
        if (this.f52156b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public boolean b() {
        return this.f52155a != null;
    }

    public void c(a aVar) {
        this.f52155a = aVar;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f52155a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f52155a.onCreateActionMode(actionMode, menu)) {
            this.f52156b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f52155a.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.f52156b;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.f52156b;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.f52156b.requestLayout();
        this.f52156b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f52155a.onPrepareActionMode(actionMode, menu);
    }
}
