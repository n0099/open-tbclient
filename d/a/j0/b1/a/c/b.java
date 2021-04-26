package d.a.j0.b1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f51456a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f51457b;

    public b(AbsHListView absHListView) {
        this.f51457b = absHListView;
    }

    @Override // d.a.j0.b1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i2, long j, boolean z) {
        this.f51456a.a(actionMode, i2, j, z);
        if (this.f51457b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public boolean b() {
        return this.f51456a != null;
    }

    public void c(a aVar) {
        this.f51456a = aVar;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f51456a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f51456a.onCreateActionMode(actionMode, menu)) {
            this.f51457b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f51456a.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.f51457b;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.f51457b;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.f51457b.requestLayout();
        this.f51457b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f51456a.onPrepareActionMode(actionMode, menu);
    }
}
