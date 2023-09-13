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
import com.baidu.tieba.bmb;
import com.baidu.tieba.fmb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.xlb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends Fragment {
    public View a;
    public ListView b;
    public kmb c;

    public final List<xlb> W1() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor b = bmb.b(getContext(), "setting_rit", new String[]{"rit"}, null, null, null, null, "rit ASC");
            if (b == null) {
                if (b != null) {
                    b.close();
                }
                return arrayList;
            }
            while (b.moveToNext()) {
                xlb xlbVar = new xlb();
                xlbVar.a = b.getString(b.getColumnIndex("rit"));
                arrayList.add(xlbVar);
            }
            if (b != null) {
                b.close();
            }
            fmb.f(arrayList);
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
        this.b = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090368);
        kmb kmbVar = new kmb(getContext(), W1());
        this.c = kmbVar;
        this.b.setAdapter((ListAdapter) kmbVar);
        this.b.setEmptyView(this.a.findViewById(16908292));
        this.b.setDivider(null);
        return this.a;
    }
}
