package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.e;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC0814a> {
    private List<T> data;
    private d nYY;
    private e nYZ;
    private int njS;

    public abstract void a(View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.njS = i;
        this.nYY = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.njS = i;
        this.nYY = dVar;
        this.nYZ = eVar;
    }

    public void fC(List<T> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G */
    public View$OnLongClickListenerC0814a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC0814a(LayoutInflater.from(viewGroup.getContext()).inflate(Nf(i), viewGroup, false), this.nYY, this.nYZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Nf(int i) {
        return this.njS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, int i) {
        a(view$OnLongClickListenerC0814a, (View$OnLongClickListenerC0814a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC0814a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, T t, int i) {
        a(view$OnLongClickListenerC0814a, (View$OnLongClickListenerC0814a) t);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.recyclerview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class View$OnLongClickListenerC0814a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private d nYY;
        private e nYZ;
        private SparseArray<View> nkc;

        public View$OnLongClickListenerC0814a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void dz(View view2) {
                    if (View$OnLongClickListenerC0814a.this.nYY != null) {
                        View$OnLongClickListenerC0814a.this.nYY.onItemClick(view2, View$OnLongClickListenerC0814a.this.getLayoutPosition());
                    }
                }
            };
            this.nYY = dVar;
            this.nYZ = eVar;
            this.nkc = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V Ou(int i) {
            V v = (V) this.nkc.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.nkc.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC0814a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) Ou(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC0814a eG(int i, @ColorInt int i2) {
            TextView textView = (TextView) Ou(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0814a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) Ou(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC0814a eH(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) Ou(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0814a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) Ou(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.i(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC0814a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) Ou(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC0814a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View Ou = Ou(i);
                if (Ou != null) {
                    Ou.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC0814a r(int... iArr) {
            for (int i : iArr) {
                View Ou = Ou(i);
                if (Ou != null) {
                    Ou.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.nYZ != null) {
                this.nYZ.B(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
