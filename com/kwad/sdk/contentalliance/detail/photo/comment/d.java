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
    public Context f32914a;

    /* renamed from: c  reason: collision with root package name */
    public long f32916c;

    /* renamed from: b  reason: collision with root package name */
    public List<PhotoComment> f32915b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<b> f32917d = new ArrayList();

    public d(@NonNull Context context, @NonNull e eVar) {
        this.f32914a = context;
        a(eVar.d());
        if (eVar.d() != null) {
            for (int i2 = 0; i2 < eVar.e(); i2++) {
                PhotoComment photoComment = eVar.d().get(i2);
                b bVar = new b();
                bVar.f32906a = photoComment;
                bVar.f32907b = eVar.a();
                bVar.f32908c = eVar.c();
                bVar.f32910e = i2;
                bVar.f32912g = ag.c(photoComment.content);
                this.f32917d.add(bVar);
            }
        }
    }

    private void a(int i2) {
        long j = i2;
        if (j > this.f32916c) {
            this.f32916c = j;
        }
    }

    public long a() {
        return this.f32916c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public h onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new h(new com.kwad.sdk.contentalliance.detail.photo.newui.a.a(this.f32914a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(h hVar, int i2) {
        hVar.a(this.f32917d.get(i2));
    }

    public void a(List<PhotoComment> list) {
        if (list != null) {
            this.f32915b.clear();
            this.f32915b.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f32915b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        a(i2);
        return 0;
    }
}
