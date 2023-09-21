package com.bytedance.tools.ui.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.tieba.R;
import com.baidu.tieba.cob;
import com.baidu.tieba.pnb;
import com.baidu.tieba.tnb;
import com.baidu.tieba.xnb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends Fragment {
    public View a;
    public ListView b;
    public cob c;

    public final List<pnb> c2() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor b = tnb.b(getContext(), "setting_rit", new String[]{"rit"}, null, null, null, null, "rit ASC");
            if (b == null) {
                if (b != null) {
                    b.close();
                }
                return arrayList;
            }
            while (b.moveToNext()) {
                pnb pnbVar = new pnb();
                pnbVar.a = b.getString(b.getColumnIndex("rit"));
                arrayList.add(pnbVar);
            }
            if (b != null) {
                b.close();
            }
            xnb.f(arrayList);
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0325, viewGroup, false);
        this.a = inflate;
        this.b = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090362);
        cob cobVar = new cob(getContext(), c2());
        this.c = cobVar;
        this.b.setAdapter((ListAdapter) cobVar);
        this.b.setEmptyView(this.a.findViewById(16908292));
        this.b.setDivider(null);
        return this.a;
    }
}
