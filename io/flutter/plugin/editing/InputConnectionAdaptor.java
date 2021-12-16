package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes4.dex */
public class InputConnectionAdaptor extends BaseInputConnection implements ListenableEditingState.EditingStateWatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InputConnectionAdaptor";
    public transient /* synthetic */ FieldHolder $fh;
    public int batchEditNestDepth;
    public FlutterTextUtils flutterTextUtils;
    public final KeyboardManager keyboardManager;
    public final int mClient;
    public CursorAnchorInfo.Builder mCursorAnchorInfoBuilder;
    public final ListenableEditingState mEditable;
    public final EditorInfo mEditorInfo;
    public ExtractedTextRequest mExtractRequest;
    public ExtractedText mExtractedText;
    public final View mFlutterView;
    public InputMethodManager mImm;
    public final Layout mLayout;
    public boolean mMonitorCursorUpdate;
    public final TextInputChannel textInputChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputConnectionAdaptor(View view, int i2, TextInputChannel textInputChannel, KeyboardManager keyboardManager, ListenableEditingState listenableEditingState, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), textInputChannel, keyboardManager, listenableEditingState, editorInfo, flutterJNI};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMonitorCursorUpdate = false;
        this.mExtractedText = new ExtractedText();
        this.batchEditNestDepth = 0;
        this.mFlutterView = view;
        this.mClient = i2;
        this.textInputChannel = textInputChannel;
        this.mEditable = listenableEditingState;
        listenableEditingState.addEditingStateListener(this);
        this.mEditorInfo = editorInfo;
        this.keyboardManager = keyboardManager;
        this.flutterTextUtils = new FlutterTextUtils(flutterJNI);
        this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public static int clampIndexToEditable(int i2, Editable editable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, editable)) == null) {
            int max = Math.max(0, Math.min(editable.length(), i2));
            if (max != i2) {
                Log.d("flutter", "Text selection index was clamped (" + i2 + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
            }
            return max;
        }
        return invokeIL.intValue;
    }

    private boolean doPerformContextMenuAction(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            if (i2 == 16908319) {
                setSelection(0, this.mEditable.length());
                return true;
            } else if (i2 == 16908320) {
                int selectionStart = Selection.getSelectionStart(this.mEditable);
                int selectionEnd = Selection.getSelectionEnd(this.mEditable);
                if (selectionStart != selectionEnd) {
                    int min = Math.min(selectionStart, selectionEnd);
                    int max = Math.max(selectionStart, selectionEnd);
                    ((ClipboardManager) this.mFlutterView.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(min, max)));
                    this.mEditable.delete(min, max);
                    setSelection(min, min);
                }
                return true;
            } else if (i2 == 16908321) {
                int selectionStart2 = Selection.getSelectionStart(this.mEditable);
                int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
                if (selectionStart2 != selectionEnd2) {
                    ((ClipboardManager) this.mFlutterView.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
                }
                return true;
            } else if (i2 == 16908322) {
                ClipData primaryClip = ((ClipboardManager) this.mFlutterView.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getPrimaryClip();
                if (primaryClip != null) {
                    CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.mFlutterView.getContext());
                    int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                    int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                    int min2 = Math.min(max2, max3);
                    int max4 = Math.max(max2, max3);
                    if (min2 != max4) {
                        this.mEditable.delete(min2, max4);
                    }
                    this.mEditable.insert(min2, coerceToText);
                    int length = min2 + coerceToText.length();
                    setSelection(length, length);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    private CursorAnchorInfo getCursorAnchorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CursorAnchorInfo.Builder builder = this.mCursorAnchorInfoBuilder;
            if (builder == null) {
                this.mCursorAnchorInfoBuilder = new CursorAnchorInfo.Builder();
            } else {
                builder.reset();
            }
            this.mCursorAnchorInfoBuilder.setSelectionRange(this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd());
            int composingStart = this.mEditable.getComposingStart();
            int composingEnd = this.mEditable.getComposingEnd();
            if (composingStart >= 0 && composingEnd > composingStart) {
                this.mCursorAnchorInfoBuilder.setComposingText(composingStart, this.mEditable.toString().subSequence(composingStart, composingEnd));
            } else {
                this.mCursorAnchorInfoBuilder.setComposingText(-1, "");
            }
            return this.mCursorAnchorInfoBuilder.build();
        }
        return (CursorAnchorInfo) invokeV.objValue;
    }

    private ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest) {
        InterceptResult invokeL;
        CharSequence listenableEditingState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, extractedTextRequest)) == null) {
            ExtractedText extractedText = this.mExtractedText;
            extractedText.startOffset = 0;
            extractedText.partialStartOffset = -1;
            extractedText.partialEndOffset = -1;
            extractedText.selectionStart = this.mEditable.getSelectionStart();
            this.mExtractedText.selectionEnd = this.mEditable.getSelectionEnd();
            ExtractedText extractedText2 = this.mExtractedText;
            if (extractedTextRequest != null && (extractedTextRequest.flags & 1) != 0) {
                listenableEditingState = this.mEditable;
            } else {
                listenableEditingState = this.mEditable.toString();
            }
            extractedText2.text = listenableEditingState;
            return this.mExtractedText;
        }
        return (ExtractedText) invokeL.objValue;
    }

    private boolean handleHorizontalMovement(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            boolean z3 = false;
            if (selectionStart < 0 || selectionEnd < 0) {
                return false;
            }
            if (z) {
                min = Math.max(this.flutterTextUtils.getOffsetBefore(this.mEditable, selectionEnd), 0);
            } else {
                min = Math.min(this.flutterTextUtils.getOffsetAfter(this.mEditable, selectionEnd), this.mEditable.length());
            }
            if (selectionStart == selectionEnd && !z2) {
                z3 = true;
            }
            if (z3) {
                setSelection(min, min);
            } else {
                setSelection(selectionStart, min);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean handleVerticalMovement(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            boolean z3 = false;
            if (selectionStart < 0 || selectionEnd < 0) {
                return false;
            }
            if (selectionStart == selectionEnd && !z2) {
                z3 = true;
            }
            beginBatchEdit();
            if (z3) {
                if (z) {
                    Selection.moveUp(this.mEditable, this.mLayout);
                } else {
                    Selection.moveDown(this.mEditable, this.mLayout);
                }
                int selectionStart2 = Selection.getSelectionStart(this.mEditable);
                setSelection(selectionStart2, selectionStart2);
            } else {
                if (z) {
                    Selection.extendUp(this.mEditable, this.mLayout);
                } else {
                    Selection.extendDown(this.mEditable, this.mLayout);
                }
                setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
            }
            endBatchEdit();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.mEditable.beginBatchEdit();
            this.batchEditNestDepth++;
            return super.beginBatchEdit();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? super.clearMetaKeyStates(i2) : invokeI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.closeConnection();
            this.mEditable.removeEditingStateListener(this);
            while (this.batchEditNestDepth > 0) {
                endBatchEdit();
                this.batchEditNestDepth--;
            }
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, charSequence, i2)) == null) ? super.commitText(charSequence, i2) : invokeLI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            if (this.mEditable.getSelectionStart() == -1) {
                return true;
            }
            return super.deleteSurroundingText(i2, i3);
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? super.deleteSurroundingTextInCodePoints(i2, i3) : invokeII.booleanValue;
    }

    @Override // io.flutter.plugin.editing.ListenableEditingState.EditingStateWatcher
    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mImm.updateSelection(this.mFlutterView, this.mEditable.getSelectionStart(), this.mEditable.getSelectionEnd(), this.mEditable.getComposingStart(), this.mEditable.getComposingEnd());
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            ExtractedTextRequest extractedTextRequest = this.mExtractRequest;
            if (extractedTextRequest != null) {
                this.mImm.updateExtractedText(this.mFlutterView, extractedTextRequest.token, getExtractedText(extractedTextRequest));
            }
            if (this.mMonitorCursorUpdate) {
                this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
            }
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            boolean endBatchEdit = super.endBatchEdit();
            this.batchEditNestDepth--;
            this.mEditable.endBatchEdit();
            return endBatchEdit;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.finishComposingText() : invokeV.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mEditable : (Editable) invokeV.objValue;
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                if (keyEvent.getKeyCode() == 21) {
                    return handleHorizontalMovement(true, keyEvent.isShiftPressed());
                }
                if (keyEvent.getKeyCode() == 22) {
                    return handleHorizontalMovement(false, keyEvent.isShiftPressed());
                }
                if (keyEvent.getKeyCode() == 19) {
                    return handleVerticalMovement(true, keyEvent.isShiftPressed());
                }
                if (keyEvent.getKeyCode() == 20) {
                    return handleVerticalMovement(false, keyEvent.isShiftPressed());
                }
                if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                    EditorInfo editorInfo = this.mEditorInfo;
                    if ((131072 & editorInfo.inputType) == 0) {
                        performEditorAction(editorInfo.imeOptions & 255);
                        return true;
                    }
                }
                int selectionStart = Selection.getSelectionStart(this.mEditable);
                int selectionEnd = Selection.getSelectionEnd(this.mEditable);
                int unicodeChar = keyEvent.getUnicodeChar();
                if (selectionStart < 0 || selectionEnd < 0 || unicodeChar == 0) {
                    return false;
                }
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                beginBatchEdit();
                if (min != max) {
                    this.mEditable.delete(min, max);
                }
                this.mEditable.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
                int i2 = min + 1;
                setSelection(i2, i2);
                endBatchEdit();
                return true;
            } else if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 59 || keyEvent.getKeyCode() == 60)) {
                int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
                setSelection(selectionEnd2, selectionEnd2);
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            beginBatchEdit();
            boolean doPerformContextMenuAction = doPerformContextMenuAction(i2);
            endBatchEdit();
            return doPerformContextMenuAction;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 == 0) {
                this.textInputChannel.unspecifiedAction(this.mClient);
            } else if (i2 == 1) {
                this.textInputChannel.newline(this.mClient);
            } else if (i2 == 2) {
                this.textInputChannel.go(this.mClient);
            } else if (i2 == 3) {
                this.textInputChannel.search(this.mClient);
            } else if (i2 == 4) {
                this.textInputChannel.send(this.mClient);
            } else if (i2 == 5) {
                this.textInputChannel.next(this.mClient);
            } else if (i2 != 7) {
                this.textInputChannel.done(this.mClient);
            } else {
                this.textInputChannel.previous(this.mClient);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, bundle)) == null) {
            this.textInputChannel.performPrivateCommand(this.mClient, str, bundle);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            if ((i2 & 1) != 0) {
                this.mImm.updateCursorAnchorInfo(this.mFlutterView, getCursorAnchorInfo());
            }
            boolean z = (i2 & 2) != 0;
            if (z != this.mMonitorCursorUpdate) {
                StringBuilder sb = new StringBuilder();
                sb.append("The input method toggled cursor monitoring ");
                sb.append(z ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                Log.d(TAG, sb.toString());
            }
            this.mMonitorCursorUpdate = z;
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, keyEvent)) == null) ? this.keyboardManager.handleEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i2, i3)) == null) ? super.setComposingRegion(i2, i3) : invokeII.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        boolean composingText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, charSequence, i2)) == null) {
            beginBatchEdit();
            if (charSequence.length() == 0) {
                composingText = super.commitText(charSequence, i2);
            } else {
                composingText = super.setComposingText(charSequence, i2);
            }
            endBatchEdit();
            return composingText;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            beginBatchEdit();
            boolean selection = super.setSelection(i2, i3);
            endBatchEdit();
            return selection;
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, extractedTextRequest, i2)) == null) {
            boolean z = (i2 & 1) != 0;
            if (z == (this.mExtractRequest == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The input method toggled text monitoring ");
                sb.append(z ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                Log.d(TAG, sb.toString());
            }
            this.mExtractRequest = z ? extractedTextRequest : null;
            return getExtractedText(extractedTextRequest);
        }
        return (ExtractedText) invokeLI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputConnectionAdaptor(View view, int i2, TextInputChannel textInputChannel, KeyboardManager keyboardManager, ListenableEditingState listenableEditingState, EditorInfo editorInfo) {
        this(view, i2, textInputChannel, keyboardManager, listenableEditingState, editorInfo, new FlutterJNI());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), textInputChannel, keyboardManager, listenableEditingState, editorInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((View) objArr2[0], ((Integer) objArr2[1]).intValue(), (TextInputChannel) objArr2[2], (KeyboardManager) objArr2[3], (ListenableEditingState) objArr2[4], (EditorInfo) objArr2[5], (FlutterJNI) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
