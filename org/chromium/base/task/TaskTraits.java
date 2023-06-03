package org.chromium.base.task;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class TaskTraits {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TaskTraits BEST_EFFORT;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK;
    public static final TaskTraits CHOREOGRAPHER_FRAME;
    public static final int EXTENSION_STORAGE_SIZE = 8;
    public static final byte INVALID_EXTENSION_ID = 0;
    public static final int MAX_EXTENSION_ID = 4;
    public static final TaskTraits THREAD_POOL;
    public static final TaskTraits THREAD_POOL_BEST_EFFORT;
    public static final TaskTraits THREAD_POOL_USER_BLOCKING;
    public static final TaskTraits THREAD_POOL_USER_VISIBLE;
    public static final TaskTraits USER_BLOCKING;
    public static final TaskTraits USER_BLOCKING_MAY_BLOCK;
    public static final TaskTraits USER_VISIBLE;
    public static final TaskTraits USER_VISIBLE_MAY_BLOCK;
    public byte[] mExtensionData;
    public byte mExtensionId;
    public boolean mIsChoreographerFrame;
    public boolean mMayBlock;
    public int mPriority;
    public boolean mUseThreadPool;

    static {
        TaskTraits taskPriority = new TaskTraits().taskPriority(0);
        BEST_EFFORT = taskPriority;
        BEST_EFFORT_MAY_BLOCK = taskPriority.mayBlock();
        TaskTraits taskPriority2 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = taskPriority2;
        USER_VISIBLE_MAY_BLOCK = taskPriority2.mayBlock();
        TaskTraits taskPriority3 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = taskPriority3;
        USER_BLOCKING_MAY_BLOCK = taskPriority3.mayBlock();
        TaskTraits taskTraits = new TaskTraits();
        CHOREOGRAPHER_FRAME = taskTraits;
        taskTraits.mIsChoreographerFrame = true;
        TaskTraits taskPriority4 = new TaskTraits().threadPool().taskPriority(2);
        THREAD_POOL = taskPriority4;
        THREAD_POOL_USER_BLOCKING = taskPriority4.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = THREAD_POOL.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = THREAD_POOL.taskPriority(0);
    }

    public TaskTraits() {
        this.mPriority = 2;
    }

    public boolean hasExtension() {
        if (this.mExtensionId != 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((1147 + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37) + Arrays.hashCode(this.mExtensionData)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }

    public TaskTraits mayBlock() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mMayBlock = true;
        return taskTraits;
    }

    public TaskTraits threadPool() {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mUseThreadPool = true;
        return taskTraits;
    }

    public TaskTraits withExplicitDestination() {
        if (!this.mUseThreadPool && !hasExtension()) {
            return threadPool();
        }
        return this;
    }

    public TaskTraits(TaskTraits taskTraits) {
        this.mPriority = taskTraits.mPriority;
        this.mMayBlock = taskTraits.mMayBlock;
        this.mUseThreadPool = taskTraits.mUseThreadPool;
        this.mExtensionId = taskTraits.mExtensionId;
        this.mExtensionData = taskTraits.mExtensionData;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> taskTraitsExtensionDescriptor) {
        if (this.mExtensionId == taskTraitsExtensionDescriptor.getId()) {
            return taskTraitsExtensionDescriptor.fromSerializedData(this.mExtensionData);
        }
        return null;
    }

    public TaskTraits taskPriority(int i) {
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mPriority = i;
        return taskTraits;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaskTraits)) {
            return false;
        }
        TaskTraits taskTraits = (TaskTraits) obj;
        if (this.mPriority == taskTraits.mPriority && this.mMayBlock == taskTraits.mMayBlock && this.mUseThreadPool == taskTraits.mUseThreadPool && this.mExtensionId == taskTraits.mExtensionId && Arrays.equals(this.mExtensionData, taskTraits.mExtensionData) && this.mIsChoreographerFrame == taskTraits.mIsChoreographerFrame) {
            return true;
        }
        return false;
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> taskTraitsExtensionDescriptor, Extension extension) {
        int id = taskTraitsExtensionDescriptor.getId();
        byte[] serializedData = taskTraitsExtensionDescriptor.toSerializedData(extension);
        TaskTraits taskTraits = new TaskTraits(this);
        taskTraits.mExtensionId = (byte) id;
        taskTraits.mExtensionData = serializedData;
        return taskTraits;
    }
}
