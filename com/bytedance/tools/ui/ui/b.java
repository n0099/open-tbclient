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
import com.baidu.tieba.bob;
import com.baidu.tieba.mnb;
import com.baidu.tieba.vnb;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends Fragment {
    public View a;
    public ListView b;
    public bob c;

    public final List<mnb> c2() {
        return vnb.a(getContext());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0325, viewGroup, false);
        this.a = inflate;
        ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090362);
        this.b = listView;
        listView.setDivider(null);
        bob bobVar = new bob(getContext(), c2());
        this.c = bobVar;
        this.b.setAdapter((ListAdapter) bobVar);
        return this.a;
    }
}
