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
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC0813a> {
    private List<T> data;
    private d nXa;
    private e nXb;
    private int nhT;

    public abstract void a(View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nhT = i;
        this.nXa = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nhT = i;
        this.nXa = dVar;
        this.nXb = eVar;
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
    /* renamed from: F */
    public View$OnLongClickListenerC0813a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC0813a(LayoutInflater.from(viewGroup.getContext()).inflate(MZ(i), viewGroup, false), this.nXa, this.nXb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int MZ(int i) {
        return this.nhT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, int i) {
        a(view$OnLongClickListenerC0813a, (View$OnLongClickListenerC0813a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC0813a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, T t, int i) {
        a(view$OnLongClickListenerC0813a, (View$OnLongClickListenerC0813a) t);
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
    public static class View$OnLongClickListenerC0813a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private d nXa;
        private e nXb;
        private SparseArray<View> nie;

        public View$OnLongClickListenerC0813a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void dz(View view2) {
                    if (View$OnLongClickListenerC0813a.this.nXa != null) {
                        View$OnLongClickListenerC0813a.this.nXa.onItemClick(view2, View$OnLongClickListenerC0813a.this.getLayoutPosition());
                    }
                }
            };
            this.nXa = dVar;
            this.nXb = eVar;
            this.nie = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V Oo(int i) {
            V v = (V) this.nie.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.nie.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC0813a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) Oo(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC0813a eF(int i, @ColorInt int i2) {
            TextView textView = (TextView) Oo(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0813a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) Oo(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC0813a eG(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) Oo(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0813a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) Oo(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.i(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC0813a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) Oo(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC0813a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View Oo = Oo(i);
                if (Oo != null) {
                    Oo.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC0813a r(int... iArr) {
            for (int i : iArr) {
                View Oo = Oo(i);
                if (Oo != null) {
                    Oo.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.nXb != null) {
                this.nXb.B(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
