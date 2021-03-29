package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends RecyclerView.Adapter<h> {

    /* renamed from: a  reason: collision with root package name */
    public Context f32248a;

    /* renamed from: c  reason: collision with root package name */
    public long f32250c;

    /* renamed from: b  reason: collision with root package name */
    public List<PhotoComment> f32249b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<b> f32251d = new ArrayList();

    public d(@NonNull Context context, @NonNull e eVar) {
        this.f32248a = context;
        a(eVar.d());
        if (eVar.d() != null) {
            for (int i = 0; i < eVar.e(); i++) {
                PhotoComment photoComment = eVar.d().get(i);
                b bVar = new b();
                bVar.f32240a = photoComment;
                bVar.f32241b = eVar.a();
                bVar.f32242c = eVar.c();
                bVar.f32244e = i;
                bVar.f32246g = ag.c(photoComment.content);
                this.f32251d.add(bVar);
            }
        }
    }

    private void a(int i) {
        long j = i;
        if (j > this.f32250c) {
            this.f32250c = j;
        }
    }

    public long a() {
        return this.f32250c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public h onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new h(new com.kwad.sdk.contentalliance.detail.photo.newui.a.a(this.f32248a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(h hVar, int i) {
        hVar.a(this.f32251d.get(i));
    }

    public void a(List<PhotoComment> list) {
        if (list != null) {
            this.f32249b.clear();
            this.f32249b.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f32249b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return 0;
    }
}
