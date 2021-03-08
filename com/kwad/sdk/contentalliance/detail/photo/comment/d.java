package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends RecyclerView.Adapter<h> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f5636a;
    private long c;
    protected List<PhotoComment> b = new ArrayList();
    private List<b> d = new ArrayList();

    public d(@NonNull Context context, @NonNull e eVar) {
        this.f5636a = context;
        a(eVar.d());
        if (eVar.d() == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eVar.e()) {
                return;
            }
            PhotoComment photoComment = eVar.d().get(i2);
            b bVar = new b();
            bVar.f5634a = photoComment;
            bVar.b = eVar.a();
            bVar.c = eVar.c();
            bVar.e = i2;
            bVar.g = ag.c(photoComment.content);
            this.d.add(bVar);
            i = i2 + 1;
        }
    }

    private void a(int i) {
        if (i > this.c) {
            this.c = i;
        }
    }

    public long a() {
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public h onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new h(new com.kwad.sdk.contentalliance.detail.photo.newui.a.a(this.f5636a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(h hVar, int i) {
        hVar.a(this.d.get(i));
    }

    public void a(List<PhotoComment> list) {
        if (list != null) {
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return 0;
    }
}
