package com.mofamulu.tieba.tail;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bg;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class aq {
    public static void a(Activity activity, bg bgVar, EditText editText) {
        TextView textView = (TextView) activity.findViewById(R.id.select_ems);
        if (!bgVar.C()) {
            textView.setVisibility(8);
            return;
        }
        List D = bgVar.D();
        if (D == null || D.isEmpty()) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new ar(activity, D, editText));
        }
    }

    public static void a(Activity activity, bg bgVar, Bundle bundle) {
        EditText editText = (EditText) activity.findViewById(R.id.reply_content);
        a(activity, bgVar, editText);
        b(activity, bgVar, editText);
    }

    public static void a(EditText editText) {
        if (an.a != null) {
            Editable text = editText.getText();
            if (text != null) {
                text.append((CharSequence) an.a);
            } else {
                editText.setText(an.a);
                editText.setSelection(an.a.length());
            }
            an.a = null;
        }
    }

    protected static void b(Activity activity, bg bgVar, EditText editText) {
        String a = bg.a();
        TextView textView = (TextView) activity.findViewById(R.id.tail_text);
        LinkedList b = bgVar.b(a);
        an.b = null;
        if (b != null && b.size() != 0) {
            textView.setOnClickListener(new at(activity, b, textView, editText));
            int a2 = bgVar.a(a);
            if (a2 == -2) {
                textView.setText("无尾巴");
                an.b = null;
                return;
            }
            if (a2 == -1 && (a2 = (int) (Math.random() * b.size())) == b.size()) {
                a2 = b.size() - 1;
            }
            an.b = (an) b.get(a2);
            textView.setText(an.b.c);
        }
    }

    public static void b(Activity activity, bg bgVar, Bundle bundle) {
        String a = bg.a();
        EditText editText = (EditText) activity.findViewById(R.id.post_content);
        a(activity, bgVar, editText);
        if (TailListActivity.g) {
            TailListActivity.g = false;
            Button button = (Button) activity.findViewById(R.id.post);
            EditText editText2 = (EditText) activity.findViewById(R.id.post_title);
            ((TextView) activity.findViewById(R.id.name)).setText(R.string.tail_settings);
            boolean z = TailListActivity.j;
            List c = z ? bgVar.c(a) : bgVar.b(a);
            if (TailListActivity.k < 0) {
                editText2.setText("小尾巴" + (c == null ? 1 : c.size() + 1));
                editText.setText(activity.getString(z ? R.string.tail_default_lzl_tail : R.string.tail_default_tail));
            } else {
                an anVar = (an) c.get(TailListActivity.k);
                editText2.setText(anVar.c);
                editText.setText(anVar.d);
            }
            button.setText("保存尾巴");
            button.setOnClickListener(new av(editText2, editText, bgVar, activity, z, a));
            editText.addTextChangedListener(new aw(editText));
            return;
        }
        b(activity, bgVar, editText);
        a(editText);
    }
}
