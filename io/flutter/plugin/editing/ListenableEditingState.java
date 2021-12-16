package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ListenableEditingState extends SpannableStringBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ListenableEditingState";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBatchEditNestDepth;
    public int mChangeNotificationDepth;
    public int mComposingEndWhenBeginBatchEdit;
    public int mComposingStartWhenBeginBatchEdit;
    public BaseInputConnection mDummyConnection;
    public ArrayList<EditingStateWatcher> mListeners;
    public ArrayList<EditingStateWatcher> mPendingListeners;
    public int mSelectionEndWhenBeginBatchEdit;
    public int mSelectionStartWhenBeginBatchEdit;
    public String mTextWhenBeginBatchEdit;
    public String mToStringCache;

    /* loaded from: classes4.dex */
    public interface EditingStateWatcher {
        void didChangeEditingState(boolean z, boolean z2, boolean z3);
    }

    public ListenableEditingState(TextInputChannel.TextEditState textEditState, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textEditState, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBatchEditNestDepth = 0;
        this.mChangeNotificationDepth = 0;
        this.mListeners = new ArrayList<>();
        this.mPendingListeners = new ArrayList<>();
        if (textEditState != null) {
            setEditingState(textEditState);
        }
        this.mDummyConnection = new BaseInputConnection(this, view, true, this) { // from class: io.flutter.plugin.editing.ListenableEditingState.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ListenableEditingState this$0;
            public final /* synthetic */ Editable val$self;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(view, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, view, Boolean.valueOf(r10), this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr3 = newInitContext2.callArgs;
                        super((View) objArr3[0], ((Boolean) objArr3[1]).booleanValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$self = this;
            }

            @Override // android.view.inputmethod.BaseInputConnection
            public Editable getEditable() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$self : (Editable) invokeV.objValue;
            }
        };
    }

    private void notifyListener(EditingStateWatcher editingStateWatcher, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{editingStateWatcher, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mChangeNotificationDepth++;
            editingStateWatcher.didChangeEditingState(z, z2, z3);
            this.mChangeNotificationDepth--;
        }
    }

    private void notifyListenersIfNeeded(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z || z2 || z3) {
                Iterator<EditingStateWatcher> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    notifyListener(it.next(), z, z2, z3);
                }
            }
        }
    }

    public void addEditingStateListener(EditingStateWatcher editingStateWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editingStateWatcher) == null) {
            if (this.mChangeNotificationDepth > 0) {
                Log.e(TAG, "adding a listener " + editingStateWatcher.toString() + " in a listener callback");
            }
            if (this.mBatchEditNestDepth > 0) {
                Log.w(TAG, "a listener was added to EditingState while a batch edit was in progress");
                this.mPendingListeners.add(editingStateWatcher);
                return;
            }
            this.mListeners.add(editingStateWatcher);
        }
    }

    public void beginBatchEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mBatchEditNestDepth++;
            if (this.mChangeNotificationDepth > 0) {
                Log.e(TAG, "editing state should not be changed in a listener callback");
            }
            if (this.mBatchEditNestDepth != 1 || this.mListeners.isEmpty()) {
                return;
            }
            this.mTextWhenBeginBatchEdit = toString();
            this.mSelectionStartWhenBeginBatchEdit = getSelectionStart();
            this.mSelectionEndWhenBeginBatchEdit = getSelectionEnd();
            this.mComposingStartWhenBeginBatchEdit = getComposingStart();
            this.mComposingEndWhenBeginBatchEdit = getComposingEnd();
        }
    }

    public void endBatchEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.mBatchEditNestDepth;
            if (i2 == 0) {
                Log.e(TAG, "endBatchEdit called without a matching beginBatchEdit");
                return;
            }
            if (i2 == 1) {
                Iterator<EditingStateWatcher> it = this.mPendingListeners.iterator();
                while (it.hasNext()) {
                    notifyListener(it.next(), true, true, true);
                }
                if (!this.mListeners.isEmpty()) {
                    Log.v(TAG, "didFinishBatchEdit with " + String.valueOf(this.mListeners.size()) + " listener(s)");
                    boolean z = false;
                    notifyListenersIfNeeded(!toString().equals(this.mTextWhenBeginBatchEdit), (this.mSelectionStartWhenBeginBatchEdit == getSelectionStart() && this.mSelectionEndWhenBeginBatchEdit == getSelectionEnd()) ? false : true, (this.mComposingStartWhenBeginBatchEdit == getComposingStart() && this.mComposingEndWhenBeginBatchEdit == getComposingEnd()) ? true : true);
                }
            }
            this.mListeners.addAll(this.mPendingListeners);
            this.mPendingListeners.clear();
            this.mBatchEditNestDepth--;
        }
    }

    public final int getComposingEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BaseInputConnection.getComposingSpanEnd(this) : invokeV.intValue;
    }

    public final int getComposingStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BaseInputConnection.getComposingSpanStart(this) : invokeV.intValue;
    }

    public final int getSelectionEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Selection.getSelectionEnd(this) : invokeV.intValue;
    }

    public final int getSelectionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Selection.getSelectionStart(this) : invokeV.intValue;
    }

    public void removeEditingStateListener(EditingStateWatcher editingStateWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, editingStateWatcher) == null) {
            if (this.mChangeNotificationDepth > 0) {
                Log.e(TAG, "removing a listener " + editingStateWatcher.toString() + " in a listener callback");
            }
            this.mListeners.remove(editingStateWatcher);
            if (this.mBatchEditNestDepth > 0) {
                this.mPendingListeners.remove(editingStateWatcher);
            }
        }
    }

    public void setComposingRange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            if (i2 >= 0 && i2 < i3) {
                this.mDummyConnection.setComposingRegion(i2, i3);
            } else {
                BaseInputConnection.removeComposingSpans(this);
            }
        }
    }

    public void setEditingState(TextInputChannel.TextEditState textEditState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, textEditState) == null) {
            beginBatchEdit();
            replace(0, length(), (CharSequence) textEditState.text);
            if (textEditState.hasSelection()) {
                Selection.setSelection(this, textEditState.selectionStart, textEditState.selectionEnd);
            } else {
                Selection.removeSelection(this);
            }
            setComposingRange(textEditState.composingStart, textEditState.composingEnd);
            endBatchEdit();
        }
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.mToStringCache;
            if (str != null) {
                return str;
            }
            String spannableStringBuilder = super.toString();
            this.mToStringCache = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), charSequence, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (this.mChangeNotificationDepth > 0) {
                Log.e(TAG, "editing state should not be changed in a listener callback");
            }
            int i6 = i3 - i2;
            boolean z = true;
            boolean z2 = i6 != i5 - i4;
            for (int i7 = 0; i7 < i6 && !z2; i7++) {
                z2 |= charAt(i2 + i7) != charSequence.charAt(i4 + i7);
            }
            if (z2) {
                this.mToStringCache = null;
            }
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            int composingStart = getComposingStart();
            int composingEnd = getComposingEnd();
            SpannableStringBuilder replace = super.replace(i2, i3, charSequence, i4, i5);
            if (this.mBatchEditNestDepth > 0) {
                return replace;
            }
            boolean z3 = (getSelectionStart() == selectionStart && getSelectionEnd() == selectionEnd) ? false : true;
            if (getComposingStart() == composingStart && getComposingEnd() == composingEnd) {
                z = false;
            }
            notifyListenersIfNeeded(z2, z3, z);
            return replace;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }
}
