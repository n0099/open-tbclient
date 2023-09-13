package com.bytedance.tools.ui.ui;

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
import com.baidu.tieba.amb;
import com.baidu.tieba.imb;
import com.baidu.tieba.ulb;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends Fragment {
    public View a;
    public ListView b;
    public imb c;

    public final List<ulb> W1() {
        return amb.b(getContext());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0325, viewGroup, false);
        this.a = inflate;
        ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090368);
        this.b = listView;
        listView.setDivider(null);
        imb imbVar = new imb(getContext(), W1());
        this.c = imbVar;
        this.b.setAdapter((ListAdapter) imbVar);
        return this.a;
    }
}
