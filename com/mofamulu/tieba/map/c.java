package com.mofamulu.tieba.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.MapPostItem;
import com.baidu.tieba.model.aw;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.mofamulu.tieba.ch.NickBinder;
import com.mofamulu.tieba.ch.av;
import com.mofamulu.tieba.ch.bf;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements GoogleMap.InfoWindowAdapter {
    final /* synthetic */ FreeJumpByMapActivity a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FreeJumpByMapActivity freeJumpByMapActivity) {
        this.a = freeJumpByMapActivity;
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View a(Marker marker) {
        return null;
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View b(Marker marker) {
        HashMap hashMap;
        HashMap hashMap2;
        MapPostItem p;
        hashMap = this.a.j;
        if (hashMap == null) {
            return null;
        }
        hashMap2 = this.a.j;
        aw awVar = (aw) hashMap2.get(marker);
        if (awVar != null && (p = awVar.p()) != null) {
            if (this.b == null) {
                this.b = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.tbhp_jump_map_marker, (ViewGroup) null);
                this.c = (TextView) this.b.findViewById(R.id.user_name);
                this.d = (TextView) this.b.findViewById(R.id.time);
                this.e = (TextView) this.b.findViewById(R.id.richText);
            }
            String name = p.getAutor().getName();
            this.c.setTextColor(-16777216);
            this.c.setText(p.getAutor().getName());
            this.d.setText(awVar.f());
            this.e.setText(p.getTitle());
            av avVar = (av) NickBinder.b.a(name);
            if (avVar != null) {
                if (bf.b(avVar.b())) {
                    this.c.setText(String.valueOf(name) + "[" + avVar.b() + "]");
                }
                if (avVar.c() != 0) {
                    this.c.setTextColor(avVar.c());
                }
            }
            return this.b;
        }
        return null;
    }
}
