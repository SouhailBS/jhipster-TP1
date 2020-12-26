import { Moment } from 'moment';
import { IPost } from 'app/shared/model/post.model';

export interface IComment {
  id?: number;
  content?: string;
  commentedAt?: Moment;
  post?: IPost;
}

export class Comment implements IComment {
  constructor(public id?: number, public content?: string, public commentedAt?: Moment, public post?: IPost) {}
}
