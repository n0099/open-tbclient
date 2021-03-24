package d.b.h0.e0;

import android.content.Context;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
/* loaded from: classes3.dex */
public abstract class b {
    public c mFragement = createFragmentTabStructure();
    public TbFragmentTabIndicator mIndicator;

    public abstract c createFragmentTabStructure();

    public c getFragmentTabStructure() {
        return this.mFragement;
    }

    public abstract TbFragmentTabIndicator getTabIndicator(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }
}
