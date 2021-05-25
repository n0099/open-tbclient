package d.a.n0.c1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f52313a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f52314b;

    public b(AbsHListView absHListView) {
        this.f52314b = absHListView;
    }

    @Override // d.a.n0.c1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i2, long j, boolean z) {
        this.f52313a.a(actionMode, i2, j, z);
        if (this.f52314b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public boolean b() {
        return this.f52313a != null;
    }

    public void c(a aVar) {
        this.f52313a = aVar;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f52313a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f52313a.onCreateActionMode(actionMode, menu)) {
            this.f52314b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f52313a.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.f52314b;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.f52314b;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.f52314b.requestLayout();
        this.f52314b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f52313a.onPrepareActionMode(actionMode, menu);
    }
}
